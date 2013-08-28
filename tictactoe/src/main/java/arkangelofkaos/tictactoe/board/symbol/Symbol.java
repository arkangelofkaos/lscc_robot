package arkangelofkaos.tictactoe.board.symbol;

/**
 * @author Edward Yue Shung Wong
 */
public enum Symbol {
    BLANK("-"), NOUGHT("0"), CROSS("x");

    private final String symbol;

    private Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }


}
