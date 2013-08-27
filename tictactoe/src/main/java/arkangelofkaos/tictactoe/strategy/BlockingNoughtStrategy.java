package arkangelofkaos.tictactoe.strategy;

public class BlockingNoughtStrategy implements Strategy {
    public int nextCell(String board) {
        int blockingCellIndex = board.indexOf("0-0");
        if (blockingCellIndex != -1) {
            return blockingCellIndex + 1;
        }
        return -1;
    }
}