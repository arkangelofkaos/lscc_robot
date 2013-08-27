import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class RobotTest {

    // x0--

    private final String board;
    private final int cellToBeMarked;
    private Main.Robot robot = new Main.Robot();

    @Parameterized.Parameters
    public static Iterable<Object[]> boards() {
        return Arrays.asList(new Object[][]{
                {"---------", 0},
//                {"0--------", 8},
//                {"--------0", 0},
                {"x----x0-0", 7},
                {"0----0x-x", 7},
                {"0-x--0x0x", 4},
                {"--x" +
                        "00-" +
                        "x--", 5},
                {"0-0" +
                        "xx-" +
                        "0--", 5},



//                {"0--------", "8"}
        });
    }

    public RobotTest(String marks, int cellToBeMarked) {
        this.board = marks;
        this.cellToBeMarked = cellToBeMarked;
    }

    @Test public void
    should_blah() {
        int result = robot.execute(board);

        assertThat(result, is(cellToBeMarked));
    }

}
