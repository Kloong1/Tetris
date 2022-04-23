package tetromino;

import board.Board;
import point.Point;

public class Tetromino {

    protected int rotateIdx;
    protected Point centerPoint;
    protected Point[] points;
    protected Point[][] blocks;

    protected Board board;

    protected Tetromino(Board board) {
        this.rotateIdx = 0;
        this.centerPoint = new Point(1, 5);

        points = new Point[4];
        for (int i = 0; i < 4; i++) {
            points[i] = new Point(
                    centerPoint.getRow() + blocks[rotateIdx][i].getRow(),
                    centerPoint.getCol() + blocks[rotateIdx][i].getCol());
        }
    }

    public Point[] rotateClockwise() {
        rotateIdx = (rotateIdx + 1) % blocks.length;
        return getRotatedPoints();
    }

    public Point[] rotateAnticlockwise() {
        if (rotateIdx == 0)
            rotateIdx = blocks.length - 1;
        else
            rotateIdx--;
        return getRotatedPoints();
    }

    protected Point[] getRotatedPoints() {
        Point[] rotatedPoints = new Point[4];

        int minCol = 0;
        int maxCol = 0;

        for (int i = 0; i < 4; i++) {
            rotatedPoints[i] = new Point(
                    centerPoint.getRow() + blocks[rotateIdx][i].getRow(),
                    centerPoint.getCol() + blocks[rotateIdx][i].getCol());
            minCol = Math.min(minCol, rotatedPoints[i].getCol());
            maxCol = Math.max(maxCol, rotatedPoints[i].getCol());
        }

        if (minCol < 0) {
            for (int i = 0; i < 4; i++)
                rotatedPoints[i].addCol(-minCol);
        }
        else if (maxCol > Board.MAX_COL) {
            for (int i = 0; i < 4; i++)
                rotatedPoints[i].addCol(Board.MAX_COL - maxCol);
        }

        points = rotatedPoints;
        return points;
    }

    public Point[] getPoints() {
        return points;
    }

    public Point[] moveRight() {
        centerPoint.addCol(1);
        for (int i = 0; i < 4; i++) {
            points[i].addCol(1);
            if (points[i].getCol() > Board.MAX_COL) {
                centerPoint.addCol(-1);
                for (; i >= 0; i--)
                    points[i].addCol(-1);
                break;
            }
        }

        return points;
    }

    public Point[] moveLeft() {
        centerPoint.addCol(-1);
        for (int i = 0; i < 4; i++) {
            points[i].addCol(-1);
            if (points[i].getCol() < 0) {
                centerPoint.addCol(1);
                for (; i >= 0; i--)
                    points[i].addCol(1);
                break;
            }
        }

        return points;
    }

    public Point[] moveDown() {
        return points;
    }

    public Point[] drop() {
        return points;
    }
}
