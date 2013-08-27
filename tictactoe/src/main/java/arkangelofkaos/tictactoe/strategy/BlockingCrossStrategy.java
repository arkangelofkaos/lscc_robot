package arkangelofkaos.tictactoe.strategy;

public class BlockingCrossStrategy implements Strategy {
    public int nextCell(String board) {
        int blockingCellIndex = board.indexOf("x-x");
        if (blockingCellIndex != -1) {
            return blockingCellIndex + 1;
        }
        return -1;
    }
}