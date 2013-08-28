package arkangelofkaos.tictactoe.board.symbol;

/**
 * @author Edward Yue Shung Wong
 */
public enum Symbol {
    BLANK, NOUGHT, CROSS;

    @Override
    public String toString() {
        switch (this) {
            case NOUGHT:
                return "0";
            case CROSS:
                return "x";
            default:
                return "-";
        }
    }


}
