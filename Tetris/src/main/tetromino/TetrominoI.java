package tetromino;

import board.Board;
import point.Point;

public class TetrominoI extends Tetromino{

    private final static Point[][] BLOCKS_I;

    static {
        BLOCKS_I = new Point[2][4];
        initBlocksI();
    }

    public TetrominoI(Board board) {
        super(board);
        blocks = BLOCKS_I;
    }

    private static void initBlocksI() {
        BLOCKS_I[0] = new Point[]
                {new Point(0, 0), new Point(0, -1), new Point(0, 1), new Point(0, 2)};

        BLOCKS_I[1] = new Point[]
                {new Point(0, 0), new Point(-1, 0), new Point(1, 0), new Point(2, 0)};
    }
}
