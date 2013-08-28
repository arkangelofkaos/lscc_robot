package arkangelofkaos.tictactoe.robot;

import arkangelofkaos.tictactoe.board.line.Line;
import arkangelofkaos.tictactoe.board.symbol.Symbol;
import arkangelofkaos.tictactoe.strategy.*;

import java.util.Arrays;
import java.util.List;

import static arkangelofkaos.tictactoe.board.BoardParser.parseBoardIntoLines;
import static arkangelofkaos.tictactoe.player.CurrentPlayerCalculator.currentPlayer;
import static arkangelofkaos.tictactoe.strategy.Strategy.ERROR_CODE;

/**
 * @author Edward Yue Shung Wong
 */
public class TicTacToeRobot {

    private static final List<Strategy> naughtStrategies = Arrays.<Strategy>asList(
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
                currentPlayer(board).equals("0")
                        ? naughtStrategies
                        : crossStrategies;

        List<Line> lines = parseBoardIntoLines(board);

        Integer winningOrBlockingMove =
                strategies.parallelStream()
                        .map(strategy -> strategy.nextCell(lines))
                        .filter(move -> move != ERROR_CODE)
                        .findFirst()
                        .orElse(ERROR_CODE);

        return winningOrBlockingMove != ERROR_CODE
                ? winningOrBlockingMove
                : standardNextMoveFor(board);
    }

    private Integer standardNextMoveFor(String board) {
        return STANDARD_STRATEGIES.parallelStream()
                .map(strategy -> strategy.nextCell(board))
                .filter(move -> move != ERROR_CODE)
                .findFirst()
                .orElse(ERROR_CODE);
    }

}
