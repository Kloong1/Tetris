package tetromino;

import board.TetrisBoard;
import point.Point;

import java.awt.*;

public class TetrominoI extends Tetromino{

    private final static Point[][] BLOCKS_I;

    static {
        BLOCKS_I = new Point[2][4];
        initBlocksI();
    }

    public TetrominoI(TetrisBoard tetrisBoard) {
        super(tetrisBoard);
        blocks = BLOCKS_I;
        color = Color.CYAN;
        initPoints();
    }

    private static void initBlocksI() {
        BLOCKS_I[0] = new Point[]
                {new Point(0, 0), new Point(0, -1), new Point(0, 1), new Point(0, 2)};

        BLOCKS_I[1] = new Point[]
                {new Point(0, 0), new Point(-1, 0), new Point(1, 0), new Point(2, 0)};
    }
}
