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
        if (blockingCellIndex != -1) {
            return blockingCellIndex + 1;
        }
        blockingCellIndex = board.indexOf("" + playerSymbol + playerSymbol + Symbol.BLANK);
        if (blockingCellIndex != -1) {
            return blockingCellIndex + 2;
        }
        return -1;
    }

    @Override
    public int nextCell(List<Line> lines) {
        return lines.parallelStream()
                .map(line -> line.winningIndex(playerSymbol))
                .max()
                .orElse(-1);
    }
}