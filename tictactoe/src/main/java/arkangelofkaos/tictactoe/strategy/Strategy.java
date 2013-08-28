package arkangelofkaos.tictactoe.strategy;

import arkangelofkaos.tictactoe.board.line.Line;

import java.util.List;

public interface Strategy {

    static int ERROR_CODE = -1;

    int nextCell(String board);

    default public int nextCell(List<Line> lines) {
        return -1;
    }
}