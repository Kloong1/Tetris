package tetromino;

import board.Board;
import point.Point;

public class TetrominoJ extends Tetromino{

    private final static Point[][] BLOCKS_J;

    static {
        BLOCKS_J = new Point[4][4];
        initBlocksJ();
    }

    public TetrominoJ(Board board) {
        super(board);
        blocks = BLOCKS_J;
    }

    private static void initBlocksJ() {
        BLOCKS_J[0] = new Point[]
                {new Point(0, 0), new Point(0, -1), new Point(-1, -1), new Point(0, 1)};

        BLOCKS_J[1] = new Point[]
                {new Point(0, 0), new Point(0, -1), new Point(-1, -1), new Point(0, 1)};

        BLOCKS_J[2] = new Point[]
                {new Point(0, 0), new Point(0, -1), new Point(0, 1), new Point(1, 1)};

        BLOCKS_J[3] = new Point[]
                {new Point(0, 0), new Point(-1, 0), new Point(1, 0), new Point(1, -1)};
    }
}
