package tetromino;

import point.Point;

public class TetrominoS extends Tetromino{

    private final static Point[][] blocks;

    static {
        blocks = new Point[4][4];
        initBlocks();
    }

    @Override
    Point[] rotateClockwise() {
        rotateIdx = (rotateIdx + 1) % blocks.length;
        return blocks[rotateIdx];
    }

    @Override
    Point[] rotateAnticlockwise() {
        if (rotateIdx == 0)
            rotateIdx = blocks.length - 1;
        else
            rotateIdx--;
        return blocks[rotateIdx];
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
                {new Point(0, 0), new Point(0, -1), new Point(-1, 0), new Point(-1, 1)};

        blocks[1] = new Point[]
                {new Point(0, 0), new Point(-1, 0), new Point(0, 1), new Point(1, 1)};

        blocks[2] = new Point[]
                {new Point(0, 0), new Point(1, 0), new Point(1, -1), new Point(0, 1)};

        blocks[3] = new Point[]
                {new Point(0, 0), new Point(0, -1), new Point(-1, -1), new Point(1, 0)};
    }
}
