package arkangelofkaos.tictactoe.robot;

import arkangelofkaos.tictactoe.strategy.*;

import static arkangelofkaos.tictactoe.player.CurrentPlayerCalculator.currentPlayer;

/**
 * @author Edward Yue Shung Wong
 */
public class TicTacToeRobot {

    static Strategy[] naughtStrategies = new Strategy[]{
            new WinNoughtStrategy(),
            new BlockingCrossStrategy(),
            new CornerStrategy(),
            new MiddleStrategy(),
            new FirstEmptyCellStrategy()
    };

    static Strategy[] crossStrategies = new Strategy[]{
            new WinCrossStrategy(),
            new BlockingNoughtStrategy(),
            new CornerStrategy(),
            new MiddleStrategy(),
            new FirstEmptyCellStrategy()
    };

    public int nextMoveFor(String board) {
        Strategy[] strategies = currentPlayer(board).equals("0")
                ? naughtStrategies : crossStrategies;

        int result = -1;
        for (Strategy strategy : strategies) {
            result = strategy.nextCell(board);
            if (result != -1) {
                break;
            }
        }
        return result;
    }

}
