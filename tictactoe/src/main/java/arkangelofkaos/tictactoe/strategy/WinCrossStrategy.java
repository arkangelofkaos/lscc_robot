package arkangelofkaos.tictactoe.strategy;

public class WinCrossStrategy implements Strategy {
    public int nextCell(String board) {
        int blockingCellIndex = board.indexOf("x-x");
        if (blockingCellIndex != -1) {
            return blockingCellIndex + 1;
        }
        blockingCellIndex = board.indexOf("xx-");
        if (blockingCellIndex != -1) {
            return blockingCellIndex + 2;
        }
        return -1;
    }
}