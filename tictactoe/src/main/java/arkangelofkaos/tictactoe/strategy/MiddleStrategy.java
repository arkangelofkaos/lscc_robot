package arkangelofkaos.tictactoe.strategy;

public class MiddleStrategy implements Strategy {

    private static final int MIDDLE_CELL_INDEX = 4;

    public int nextCell(String board) {
        return (board.charAt(MIDDLE_CELL_INDEX) == '-')
                ? MIDDLE_CELL_INDEX
                : ERROR_CODE;
    }
}