package tetromino;

import point.Point;

public class TetrominoO extends Tetromino{

    private final static Point[][] blocks;

    static {
        blocks = new Point[1][4];
        initBlocks();
    }

    @Override
    Point[] rotateClockwise() {
        return blocks[0];
    }

    @Override
    Point[] rotateAnticlockwise() {
        return blocks[0];
    }

    @Override
    Point[] moveRight() {
        return new Point[0];
    }

    @Override
    Point[] moveLeft() {
        return new Point[0];
    }

    @Override
    Point[] moveDown() {
        return new Point[0];
    }

    @Override
    Point[] drop() {
        return new Point[0];
    }

    private static void initBlocks() {
        blocks[0] = new Point[]
                {new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)};
    }
}
