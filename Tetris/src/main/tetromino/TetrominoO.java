package tetromino;

import board.Board;
import point.Point;

public class TetrominoO extends Tetromino{

    private final static Point[][] BLOCKS_O;

    static {
        BLOCKS_O = new Point[1][4];
        initBlocksO();
    }

    public TetrominoO(Board board) {
        super(board);
        blocks = BLOCKS_O;
        initPoints();
    }

    @Override
    public Point[] rotateClockwise() {
        return getPoints();
    }

    @Override
    public Point[] rotateAnticlockwise() {
        return getPoints();
    }

    private static void initBlocksO() {
        BLOCKS_O[0] = new Point[]
                {new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)};
    }
}
