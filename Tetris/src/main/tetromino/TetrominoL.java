package tetromino;

import board.TetrisBoard;
import point.Point;

import java.awt.*;

public class TetrominoL extends Tetromino{

    private final static Point[][] BLOCKS_L;

    static {
        BLOCKS_L = new Point[4][4];
        initBlocksL();
    }

    public TetrominoL(TetrisBoard tetrisBoard) {
        super(tetrisBoard);
        blocks = BLOCKS_L;
        color = Color.ORANGE;
        initPoints();
    }

    private static void initBlocksL() {
        BLOCKS_L[0] = new Point[]
                {new Point(0, 0), new Point(0, -1), new Point(0, 1), new Point(-1, 1)};

        BLOCKS_L[1] = new Point[]
                {new Point(0, 0), new Point(-1, 0), new Point(1, 0), new Point(1, 1)};

        BLOCKS_L[2] = new Point[]
                {new Point(0, 0), new Point(0, -1), new Point(1, -1), new Point(0, 1)};

        BLOCKS_L[3] = new Point[]
                {new Point(0, 0), new Point(-1, 0), new Point(-1, -1), new Point(1, 0)};

    }
}
