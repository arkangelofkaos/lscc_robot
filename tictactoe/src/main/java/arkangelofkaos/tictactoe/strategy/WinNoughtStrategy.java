package arkangelofkaos.tictactoe.strategy;

public class WinNoughtStrategy implements Strategy {

    public int nextCell(String board) {
        int blockingCellIndex = board.indexOf("0-0");
        if (blockingCellIndex != -1) {
            return blockingCellIndex + 1;
        }
        blockingCellIndex = board.indexOf("00-");
        if (blockingCellIndex != -1) {
            return blockingCellIndex + 2;
        }
        return -1;
    }
}