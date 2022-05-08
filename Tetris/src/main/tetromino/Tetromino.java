package tetromino;

import board.TetrisBoard;
import point.Point;

import java.awt.*;

public class Tetromino {

    protected int rotateIdx;
    protected Point centerPoint;
    protected Point[] points;
    protected Point[][] blocks;
    protected Color color;

    protected final TetrisBoard tetrisBoard;

    protected Tetromino(TetrisBoard tetrisBoard) {
        this.tetrisBoard = tetrisBoard;
        this.centerPoint = new Point(1, 4);
    }

    protected void initPoints() {
        points = new Point[4];
        for (int i = 0; i < 4; i++) {
            points[i] = new Point(
                    centerPoint.getRow() + blocks[rotateIdx][i].getRow(),
                    centerPoint.getCol() + blocks[rotateIdx][i].getCol());
        }
    }

    public Point[] getPoints() {
        return points;
    }

    public Color getColor() {
        return color;
    }

    public Point[] rotateClockwise() {
        int nextRotateIdx = (rotateIdx + 1) % blocks.length;
        return getRotatedPoints(nextRotateIdx);
    }

    public Point[] rotateAnticlockwise() {
        int nextRotateIdx = rotateIdx == 0 ? blocks.length - 1 : rotateIdx - 1;
        return getRotatedPoints(nextRotateIdx);
    }

    private Point[] getRotatedPoints(int nextRotateIdx) {
        Point[] rotatedPoints = new Point[4];
        Point nextCenterPoint = new Point(centerPoint);

        int minCol = 0, maxCol = 0;
        int minRow = 0, maxRow = 0;

        for (int i = 0; i < 4; i++) {
            rotatedPoints[i] = new Point(
                    nextCenterPoint.getRow() + blocks[nextRotateIdx][i].getRow(),
                    nextCenterPoint.getCol() + blocks[nextRotateIdx][i].getCol());
            minCol = Math.min(minCol, rotatedPoints[i].getCol());
            maxCol = Math.max(maxCol, rotatedPoints[i].getCol());
            minRow = Math.min(minRow, rotatedPoints[i].getRow());
            maxRow = Math.max(maxRow, rotatedPoints[i].getRow());
        }

        moveTetrominoInsideColumn(rotatedPoints, nextCenterPoint, minCol, maxCol);
        moveTetrominoInsideRow(rotatedPoints, nextCenterPoint, minRow, maxRow);

        if (checkTetrominoOverlappingLine(rotatedPoints)) {
            for (Point rotatedPoint : rotatedPoints) {
                rotatedPoint.addRow(-2);
                if (rotatedPoint.getRow() < 0) {
                    return points;
                }
            }
            if (checkTetrominoOverlappingLine(rotatedPoints)) {
                return points;
            }
        }

        points = rotatedPoints;
        centerPoint = nextCenterPoint;
        rotateIdx = nextRotateIdx;

        return points;
    }

    private void moveTetrominoInsideColumn(Point[] rotatedPoints, Point nextCenterPoint, int minCol, int maxCol) {
        if (minCol < 0) {
            nextCenterPoint.addCol(-minCol);
            for (int i = 0; i < 4; i++)
                rotatedPoints[i].addCol(-minCol);
        }
        else if (maxCol > TetrisBoard.MAX_COL) {
            nextCenterPoint.addCol(TetrisBoard.MAX_COL - maxCol);
            for (int i = 0; i < 4; i++)
                rotatedPoints[i].addCol(TetrisBoard.MAX_COL - maxCol);
        }
    }

    private void moveTetrominoInsideRow(Point[] rotatedPoints, Point nextCenterPoint, int minRow, int maxRow) {
        if (minRow < 0) {
            nextCenterPoint.addRow(-minRow);
            for (int i = 0; i < 4; i++)
                rotatedPoints[i].addRow(-minRow);
        }
        else if (maxRow > TetrisBoard.MAX_ROW) {
            nextCenterPoint.addRow(TetrisBoard.MAX_ROW - maxRow);
            for (int i = 0; i < 4; i++)
                rotatedPoints[i].addRow(TetrisBoard.MAX_ROW - maxRow);
        }
    }

    public Point[] moveRight() {
        centerPoint.addCol(1);
        for (int i = 0; i < 4; i++) {
            points[i].addCol(1);
            if (points[i].getCol() > TetrisBoard.MAX_COL || checkPointOverlappingLine(points[i])) {
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
            if (points[i].getCol() < 0 || checkPointOverlappingLine(points[i])) {
                centerPoint.addCol(1);
                for (; i >= 0; i--)
                    points[i].addCol(1);
                break;
            }
        }

        return points;
    }

    public Point[] moveDown() {
        centerPoint.addRow(1);
        for (int i = 0; i < 4; i++) {
            points[i].addRow(1);
            if (points[i].getRow() > TetrisBoard.MAX_ROW || checkPointOverlappingLine(points[i])) {
                centerPoint.addRow(-1);
                for (; i >= 0; i--)
                    points[i].addRow(-1);
                return null;
            }
        }
        return points;
    }

    public Point[] drop() {
        boolean[][] brd = tetrisBoard.getBoard();
        int minDistance = 20;
        int tempDistance;
        int row, col;

        for (Point point : points) {
            tempDistance = 1;
            row = point.getRow();
            col = point.getCol();
            while (row + tempDistance <= TetrisBoard.MAX_ROW && !brd[row + tempDistance][col])
                tempDistance++;
            minDistance = Math.min(minDistance, tempDistance - 1);
        }

        if (minDistance > 0) {
            centerPoint.addRow(minDistance);
            for (Point point : points)
                point.addRow(minDistance);
        }

        return points;
    }

    private boolean checkPointOverlappingLine(Point point) {
        return tetrisBoard.getBoard()[point.getRow()][point.getCol()];
    }

    private boolean checkTetrominoOverlappingLine(Point[] points) {
        boolean[][] brd = tetrisBoard.getBoard();

        for (Point point : points) {
            if (brd[point.getRow()][point.getCol()])
                return true;
        }
        return false;
    }
}
