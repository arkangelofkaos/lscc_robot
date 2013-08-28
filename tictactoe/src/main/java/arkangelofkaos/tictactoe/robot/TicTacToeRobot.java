package arkangelofkaos.tictactoe.robot;

import arkangelofkaos.tictactoe.board.line.Line;
import arkangelofkaos.tictactoe.board.symbol.Symbol;
import arkangelofkaos.tictactoe.strategy.CornerStrategy;
import arkangelofkaos.tictactoe.strategy.FirstEmptyCellStrategy;
import arkangelofkaos.tictactoe.strategy.MiddleStrategy;
import arkangelofkaos.tictactoe.strategy.Strategy;
import arkangelofkaos.tictactoe.strategy.WinningStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.ToIntFunction;

import static arkangelofkaos.tictactoe.board.BoardParser.parseBoardIntoLines;
import static arkangelofkaos.tictactoe.player.CurrentPlayerCalculator.currentPlayer;
import static arkangelofkaos.tictactoe.strategy.Strategy.ERROR_CODE;

/**
 * @author Edward Yue Shung Wong
 */
public class TicTacToeRobot {

    private static final List<Strategy> noughtStrategies = Arrays.<Strategy>asList(
            new WinningStrategy(Symbol.NOUGHT),
            new WinningStrategy(Symbol.CROSS)
    );

    private static final List<Strategy> crossStrategies = Arrays.<Strategy>asList(
            new WinningStrategy(Symbol.CROSS),
            new WinningStrategy(Symbol.NOUGHT)
    );

    private static final List<Strategy> STANDARD_STRATEGIES = Arrays.asList(
            new CornerStrategy(),
            new MiddleStrategy(),
            new FirstEmptyCellStrategy()
    );

    public int nextMoveFor(String board) {
        List<Strategy> strategies =
                noughtIsCurrentPlayer(board)
                        ? noughtStrategies
                        : crossStrategies;

        Integer winningOrBlockingMove = winningOrBlockingMoveFor(strategies, board);

        return winningOrBlockingMove != ERROR_CODE
                ? winningOrBlockingMove
                : standardNextMoveFor(board);
    }

    private Integer winningOrBlockingMoveFor(List<Strategy> playerStrategies, String board) {
        List<Line> lines = parseBoardIntoLines(board);
        return playerStrategies.parallelStream()
                .mapToInt(strategiesToMoves(lines))
                .filter(badMoves())
                .findFirst()
                .orElse(ERROR_CODE);
    }

    private Integer standardNextMoveFor(String board) {
        return STANDARD_STRATEGIES.parallelStream()
                .mapToInt(strategiesToMoves(board))
                .filter(badMoves())
                .findFirst()
                .getAsInt();
    }

    private boolean noughtIsCurrentPlayer(String board) {
        return Symbol.NOUGHT.getSymbol().equals(currentPlayer(board));
    }

    private ToIntFunction<? super Strategy> strategiesToMoves(List<Line> lines) {
        return strategy -> strategy.nextCell(lines);
    }

    private ToIntFunction<? super Strategy> strategiesToMoves(String board) {
        return strategy -> strategy.nextCell(board);
    }

    private IntPredicate badMoves() {
        return move -> move != ERROR_CODE;
    }

}
