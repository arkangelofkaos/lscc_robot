package arkangelofkaos.tictactoe.robot;

import arkangelofkaos.tictactoe.board.line.Line;
import arkangelofkaos.tictactoe.board.symbol.Symbol;
import arkangelofkaos.tictactoe.strategy.*;

import java.util.Arrays;
import java.util.List;

import static arkangelofkaos.tictactoe.board.BoardParser.parseBoardIntoLines;
import static arkangelofkaos.tictactoe.player.CurrentPlayerCalculator.currentPlayer;

/**
 * @author Edward Yue Shung Wong
 */
public class TicTacToeRobot {

    private static final List<WinningStrategy> naughtStrategies = Arrays.asList(
            new WinningStrategy(Symbol.NOUGHT),
            new WinningStrategy(Symbol.CROSS)
    );

    private static final List<WinningStrategy> crossStrategies = Arrays.asList(
            new WinningStrategy(Symbol.CROSS),
            new WinningStrategy(Symbol.NOUGHT)
    );

    private static final List<Strategy> STANDARD_STRATEGIES = Arrays.asList(
            new CornerStrategy(),
            new MiddleStrategy(),
            new FirstEmptyCellStrategy()
    );

    public int nextMoveFor(String board) {
        List<WinningStrategy> strategies =
                currentPlayer(board).equals("0")
                        ? naughtStrategies
                        : crossStrategies;

        List<Line> lines = parseBoardIntoLines(board);

        Integer winningOrBlockingMove =
                strategies.parallelStream()
                        .map(strategy -> strategy.nextCell(lines))
                        .filter(move -> move != -1)
                        .findFirst()
                        .orElse(-1);

        return winningOrBlockingMove != -1
                ? winningOrBlockingMove
                : standardNextMoveFor(board);
    }

    private Integer standardNextMoveFor(String board) {
        return STANDARD_STRATEGIES.parallelStream()
                .map(strategy -> strategy.nextCell(board))
                .filter(move -> move != -1)
                .findFirst()
                .orElse(-1);
    }

}
