package tetromino;

import board.TetrisBoard;
import point.Point;

public class TetrominoZ extends Tetromino{

    private final static Point[][] BLOCKS_Z;

    static {
        BLOCKS_Z = new Point[4][4];
        initBlocksZ();
    }

    public TetrominoZ(TetrisBoard tetrisBoard) {
        super(tetrisBoard);
        blocks = BLOCKS_Z;
        initPoints();
    }

    private static void initBlocksZ() {
        BLOCKS_Z[0] = new Point[]
                {new Point(0, 0), new Point(-1, 0), new Point(-1, -1), new Point(0, 1)};

        BLOCKS_Z[1] = new Point[]
                {new Point(0, 0), new Point(0, 1), new Point(-1, 1), new Point(1, 0)};

        BLOCKS_Z[2] = new Point[]
                {new Point(0, 0), new Point(0, -1), new Point(1, 0), new Point(1, 1)};

        BLOCKS_Z[3] = new Point[]
                {new Point(0, 0), new Point(-1, 0), new Point(0, -1), new Point(1, -1)};
    }
}
