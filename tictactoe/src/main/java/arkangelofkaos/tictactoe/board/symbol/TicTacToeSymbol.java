package arkangelofkaos.tictactoe.board.symbol;

/**
 * @author Edward Yue Shung Wong
 */
public class TicTacToeSymbol {

    private final int index;

    private final Symbol symbol;

    public TicTacToeSymbol(int index, Symbol symbol) {
        this.index = index;
        this.symbol = symbol;
    }

    public int getIndex() {
        return index;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TicTacToeSymbol that = (TicTacToeSymbol) o;

        if (index != that.index) {
            return false;
        }
        if (symbol != that.symbol) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = index;
        result = 31 * result + symbol.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return symbol.toString();
    }
}
