package arkangelofkaos.tictactoe.board;

import arkangelofkaos.tictactoe.board.line.Line;
import arkangelofkaos.tictactoe.board.symbol.Symbol;
import arkangelofkaos.tictactoe.board.symbol.TicTacToeSymbol;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

/**
 * @author Edward Yue Shung Wong
 */
public class BoardParser {

    public static List<Line> parseBoardIntoLines(String board) {
        int[][] allLineIndexes = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 4, 8},
                {2, 4, 6}
        };

        return Arrays.stream(allLineIndexes)
                .map(lineIndexesToTicTacToeSymbols(board))
                .map(Line::new)
                .collect(Collectors.<Line>toList());
    }

    private static Function<? super int[], ? extends List<TicTacToeSymbol>> lineIndexesToTicTacToeSymbols(String board) {
        return lineIndexes ->
                Arrays.stream(lineIndexes)
                        .mapToObj(indexToSymbolOn(board))
                        .collect(Collectors.<TicTacToeSymbol>toList());
    }

    private static IntFunction<TicTacToeSymbol> indexToSymbolOn(String board) {
        return index -> {
            Symbol symbol;

            switch (board.charAt(index)) {
                case '0':
                    symbol = Symbol.NOUGHT;
                    break;
                case 'x':
                    symbol = Symbol.CROSS;
                    break;
                default:
                    symbol = Symbol.BLANK;
                    break;
            }

            return new TicTacToeSymbol(index, symbol);
        };
    }
}
