package arkangelofkaos.tictactoe.player;

public final class CurrentPlayerCalculator {

    private CurrentPlayerCalculator() {
    }

    public static String currentPlayer(String board) {
        String boardWithNoEmptyCells = board.replaceAll("-", "");
        int nought = boardWithNoEmptyCells.replaceAll("x", "").length();
        int cross = boardWithNoEmptyCells.replaceAll("0", "").length();

        return (nought == cross) ? "0" : "x";
    }
}