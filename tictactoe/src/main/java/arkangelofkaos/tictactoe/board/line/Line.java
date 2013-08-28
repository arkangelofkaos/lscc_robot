package arkangelofkaos.tictactoe.board.line;

import arkangelofkaos.tictactoe.board.symbol.TicTacToeSymbol;

import java.util.List;

/**
 * @author Edward Yue Shung Wong
 */
public class Line {

    private final TicTacToeSymbol ticTacToeSymbol1, ticTacToeSymbol2, ticTacToeSymbol3;

    public Line(TicTacToeSymbol ticTacToeSymbol1, TicTacToeSymbol ticTacToeSymbol2, TicTacToeSymbol ticTacToeSymbol3) {
        this.ticTacToeSymbol1 = ticTacToeSymbol1;
        this.ticTacToeSymbol2 = ticTacToeSymbol2;
        this.ticTacToeSymbol3 = ticTacToeSymbol3;
    }

    public Line(List<TicTacToeSymbol> ticTacToeSymbols) {
        this(ticTacToeSymbols.get(0), ticTacToeSymbols.get(1), ticTacToeSymbols.get(2));
    }


    public TicTacToeSymbol getTicTacToeSymbol1() {
        return ticTacToeSymbol1;
    }

    public TicTacToeSymbol getTicTacToeSymbol2() {
        return ticTacToeSymbol2;
    }

    public TicTacToeSymbol getTicTacToeSymbol3() {
        return ticTacToeSymbol3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Line line = (Line) o;

        if (!ticTacToeSymbol1.equals(line.ticTacToeSymbol1)) {
            return false;
        }
        if (!ticTacToeSymbol2.equals(line.ticTacToeSymbol2)) {
            return false;
        }
        if (!ticTacToeSymbol3.equals(line.ticTacToeSymbol3)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = ticTacToeSymbol1.hashCode();
        result = 31 * result + ticTacToeSymbol2.hashCode();
        result = 31 * result + ticTacToeSymbol3.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Line{" + ticTacToeSymbol1 + ticTacToeSymbol2 + ticTacToeSymbol3 + '}';
    }
}
