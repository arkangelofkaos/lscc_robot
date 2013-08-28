package arkangelofkaos.tictactoe.strategy;

public class MiddleStrategy implements Strategy {
    public int nextCell(String board) {
        return (board.charAt(4) == '-') ? 4 : ERROR_CODE;
    }
}