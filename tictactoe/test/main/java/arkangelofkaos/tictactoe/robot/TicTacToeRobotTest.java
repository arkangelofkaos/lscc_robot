package arkangelofkaos.tictactoe.robot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.runners.Parameterized.Parameters;

/**
 * @author Edward Yue Shung Wong
 */
@RunWith(Parameterized.class)
public class TicTacToeRobotTest {

    private final TicTacToeRobot robot = new TicTacToeRobot();

    private final String board;
    private final int cellToBeMarked;

    @Parameters
    public static Iterable<Object[]> boards() {
        return Arrays.asList(new Object[][]{
                {"---------", 0},
                {"x----x0-0", 7},
                {"0----0x-x", 7},
                {"0-x--0x0x", 4},
                {"--x00-x--", 5},
                {"0-0xx-0--", 5},
        });
    }

    public TicTacToeRobotTest(String marks, int cellToBeMarked) {
        this.board = marks;
        this.cellToBeMarked = cellToBeMarked;
    }

    @Test
    public void shouldCalculateNextMove() {
        int result = robot.nextMoveFor(board);
        assertThat(result, is(cellToBeMarked));
    }

}
