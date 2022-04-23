package tetromino;

import board.Board;
import point.Point;

public class TetrominoZ extends Tetromino{

    private final static Point[][] BLOCKS_Z;

    static {
        BLOCKS_Z = new Point[4][4];
        initBlocksZ();
    }

    public TetrominoZ(Board board) {
        super(board);
        blocks = BLOCKS_Z;
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
