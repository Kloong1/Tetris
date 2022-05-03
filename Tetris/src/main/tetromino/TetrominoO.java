package tetromino;

import board.TetrisBoard;
import point.Point;

import java.awt.*;

public class TetrominoO extends Tetromino{

    private final static Point[][] BLOCKS_O;

    static {
        BLOCKS_O = new Point[1][4];
        initBlocksO();
    }

    public TetrominoO(TetrisBoard tetrisBoard) {
        super(tetrisBoard);
        blocks = BLOCKS_O;
        color = Color.YELLOW;
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
