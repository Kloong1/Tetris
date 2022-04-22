package tetromino;

import point.Point;

public class TetrominoI extends Tetromino{

    private final static Point[][] blocks;

    static {
        blocks = new Point[2][4];
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

//    private Point[] getNextPoints() {
//        Point[] points = new Point[4];
//
//        for (int i = 0; i < 4; i++) {
//            points[i].setRow(point.getRow() + blocks[rotateIdx][i].getRow());
//            points[i].setCol(point.getCol() + blocks[rotateIdx][i].getCol());
//        }
//
//        return points;
//    }

    private static void initBlocks() {

        blocks[0] = new Point[]
                {new Point(0, 0), new Point(0, -1), new Point(0, 1), new Point(0, 2)};

        blocks[1] = new Point[]
                {new Point(0, 0), new Point(-1, 0), new Point(1, 0), new Point(2, 0)};
    }
}
