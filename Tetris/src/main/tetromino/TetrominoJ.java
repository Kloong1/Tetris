package tetromino;

import board.TetrisBoard;
import point.Point;

import java.awt.*;

public class TetrominoJ extends Tetromino{

    private final static Point[][] BLOCKS_J;

    static {
        BLOCKS_J = new Point[4][4];
        initBlocksJ();
    }

    public TetrominoJ(TetrisBoard tetrisBoard) {
        super(tetrisBoard);
        blocks = BLOCKS_J;
        color = Color.BLUE;
        initPoints();
    }

    private static void initBlocksJ() {
        BLOCKS_J[0] = new Point[]
                {new Point(0, 0), new Point(0, -1), new Point(-1, -1), new Point(0, 1)};

        BLOCKS_J[1] = new Point[]
                {new Point(0, 0), new Point(-1, 0), new Point(-1, 1), new Point(1, 0)};

        BLOCKS_J[2] = new Point[]
                {new Point(0, 0), new Point(0, -1), new Point(0, 1), new Point(1, 1)};

        BLOCKS_J[3] = new Point[]
                {new Point(0, 0), new Point(-1, 0), new Point(1, 0), new Point(1, -1)};
    }
}
