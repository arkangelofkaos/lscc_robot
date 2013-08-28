package arkangelofkaos.tictactoe.strategy;

import java.util.Arrays;
import java.util.List;

public class CornerStrategy implements Strategy {
    List<Integer> corners = Arrays.asList(0, 2, 6, 8);

    public int nextCell(String board) {
        for (int corner : corners) {
            if (board.charAt(corner) == '-') {
                return corner;
            }
        }

        return ERROR_CODE;
    }
}