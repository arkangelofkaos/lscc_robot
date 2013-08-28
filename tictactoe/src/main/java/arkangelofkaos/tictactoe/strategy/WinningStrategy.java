package arkangelofkaos.tictactoe.strategy;

import arkangelofkaos.tictactoe.board.line.Line;
import arkangelofkaos.tictactoe.board.symbol.Symbol;

import java.util.List;

public class WinningStrategy implements Strategy {
    private final Symbol playerSymbol;

    public WinningStrategy(Symbol playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    public int nextCell(String board) {
        int blockingCellIndex = board.indexOf("" + playerSymbol + Symbol.BLANK + playerSymbol);
        if (blockingCellIndex != ERROR_CODE) {
            return blockingCellIndex + 1;
        }
        blockingCellIndex = board.indexOf("" + playerSymbol + playerSymbol + Symbol.BLANK);
        if (blockingCellIndex != ERROR_CODE) {
            return blockingCellIndex + 2;
        }
        return ERROR_CODE;
    }

    @Override
    public int nextCell(List<Line> lines) {
        return lines.parallelStream()
                .mapToInt(line -> line.winningIndex(playerSymbol))
                .max()
                .getAsInt();
    }
}