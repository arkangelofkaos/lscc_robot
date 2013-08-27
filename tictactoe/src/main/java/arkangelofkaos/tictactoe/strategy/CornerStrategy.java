package arkangelofkaos.tictactoe.strategy;

public class CornerStrategy implements Strategy {
    int corners[] = {0, 2, 6, 8};

    public int nextCell(String board) {
        for (int corner : corners) {
            if (board.charAt(corner) == '-') {
                return corner;
            }
        }

        return -1;
    }
}