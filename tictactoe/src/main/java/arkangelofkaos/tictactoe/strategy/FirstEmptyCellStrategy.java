package arkangelofkaos.tictactoe.strategy;

public class FirstEmptyCellStrategy implements Strategy {
    public int nextCell(String board) {
        return board.indexOf("-");
    }
}