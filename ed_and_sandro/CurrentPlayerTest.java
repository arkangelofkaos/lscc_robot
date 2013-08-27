import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class CurrentPlayerTest {

    private final String board;
    private final String currentPlayer;

    @Parameterized.Parameters
    public static Iterable<Object[]> boards() {
        return Arrays.asList(new Object[][]{
                {"---------", "0"},
                {"0--------", "x"}
        });


    }


    public CurrentPlayerTest(String board, String currentPlayer) {
        this.board = board;
        this.currentPlayer = currentPlayer;
    }


    @Test
    public void
    should_blah() {
        String result = Main.CurrentPlayerCalculator.currentPlayer(board);

        assertThat(result, is(currentPlayer));
    }


}
