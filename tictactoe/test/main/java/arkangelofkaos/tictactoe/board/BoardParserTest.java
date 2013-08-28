package arkangelofkaos.tictactoe.board;

import arkangelofkaos.tictactoe.board.line.Line;
import arkangelofkaos.tictactoe.board.symbol.Symbol;
import arkangelofkaos.tictactoe.board.symbol.TicTacToeSymbol;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Edward Yue Shung Wong
 */
public class BoardParserTest {

    private final BoardParser boardParser = new BoardParser();

    @Test
    public void shouldParseEmptyBoardToLines() throws Exception {
        assertThat(boardParser.parseBoardIntoLines("---------"),
                is(Arrays.asList(
                        new Line(new TicTacToeSymbol(0, Symbol.BLANK), new TicTacToeSymbol(1, Symbol.BLANK), new TicTacToeSymbol(2, Symbol.BLANK)),
                        new Line(new TicTacToeSymbol(3, Symbol.BLANK), new TicTacToeSymbol(4, Symbol.BLANK), new TicTacToeSymbol(5, Symbol.BLANK)),
                        new Line(new TicTacToeSymbol(6, Symbol.BLANK), new TicTacToeSymbol(7, Symbol.BLANK), new TicTacToeSymbol(8, Symbol.BLANK)),
                        new Line(new TicTacToeSymbol(0, Symbol.BLANK), new TicTacToeSymbol(4, Symbol.BLANK), new TicTacToeSymbol(8, Symbol.BLANK)),
                        new Line(new TicTacToeSymbol(2, Symbol.BLANK), new TicTacToeSymbol(4, Symbol.BLANK), new TicTacToeSymbol(6, Symbol.BLANK))
                ))
        );
    }

    @Test
    public void shouldParseNonEmptyBoardToLines() throws Exception {
        assertThat(boardParser.parseBoardIntoLines("x-------0"),
                is(Arrays.asList(
                        new Line(new TicTacToeSymbol(0, Symbol.CROSS), new TicTacToeSymbol(1, Symbol.BLANK), new TicTacToeSymbol(2, Symbol.BLANK)),
                        new Line(new TicTacToeSymbol(3, Symbol.BLANK), new TicTacToeSymbol(4, Symbol.BLANK), new TicTacToeSymbol(5, Symbol.BLANK)),
                        new Line(new TicTacToeSymbol(6, Symbol.BLANK), new TicTacToeSymbol(7, Symbol.BLANK), new TicTacToeSymbol(8, Symbol.NOUGHT)),
                        new Line(new TicTacToeSymbol(0, Symbol.CROSS), new TicTacToeSymbol(4, Symbol.BLANK), new TicTacToeSymbol(8, Symbol.NOUGHT)),
                        new Line(new TicTacToeSymbol(2, Symbol.BLANK), new TicTacToeSymbol(4, Symbol.BLANK), new TicTacToeSymbol(6, Symbol.BLANK))
                ))
        );
    }
}
