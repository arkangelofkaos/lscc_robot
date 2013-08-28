package arkangelofkaos.tictactoe.player;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import static arkangelofkaos.tictactoe.board.symbol.Symbol.*;

public final class CurrentPlayerCalculator {

    private static final int NOUGHT_TURN = 0;

    public static final int NOUGHT_TURN_VALUE = 1;
    public static final int CROSS_TURN_VALUE = -1;

    private CurrentPlayerCalculator() {
    }

    public static String currentPlayer(String board) {
        // TODO - figure out how to get char stream from String (need a newer JDK 8?)
        List<String> boardSymbols = new ArrayList<>(board.length());
        for (char c : board.toCharArray()) {
            boardSymbols.add(String.valueOf(c));
        }

        String blankSymbol = BLANK.getSymbol();
        String crossSymbol = CROSS.getSymbol();
        String noughtSymbol = NOUGHT.getSymbol();

        int playerTurn = sumPlayerTurnsToSeeIfEachHadEqualGoes(boardSymbols, blankSymbol, crossSymbol);
        return (playerTurn == NOUGHT_TURN) ? noughtSymbol : crossSymbol;
    }

    private static int sumPlayerTurnsToSeeIfEachHadEqualGoes(List<String> boardSymbols,
                                                             String blankSymbol, String crossSymbol) {
        return boardSymbols.parallelStream()
                .filter(blanks(blankSymbol))
                .map(symbolsToTurnValues(crossSymbol))
                .sum();
    }

    private static Predicate<? super String> blanks(String blankSymbol) {
        return symbol -> !blankSymbol.equals(symbol);
    }

    private static ToIntFunction<? super String> symbolsToTurnValues(String crossSymbol) {
        return symbol -> crossSymbol.equals(symbol) ? CROSS_TURN_VALUE : NOUGHT_TURN_VALUE;
    }
}