package tetromino;

import board.Board;
import point.Point;

public class Tetromino {

    protected int rotateIdx;
    protected Point centerPoint;
    protected Point[] points;
    protected Point[][] blocks;

    protected final Board board;

    protected Tetromino(Board board) {
        this.board = board;
        this.centerPoint = new Point(1, 5);
    }

    protected void initPoints() {
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

    private Point[] getRotatedPoints() {
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

        moveTetrominoInsideBoard(rotatedPoints, minCol, maxCol);

        if (checkTetrominoOverlappingLine(rotatedPoints)) {
            for (Point point : rotatedPoints) {
                point.addRow(-2);
                if (point.getRow() < 0)
                    return points;
            }
            if (checkTetrominoOverlappingLine(rotatedPoints))
                return points;
        }

        points = rotatedPoints;
        return points;
    }

    private void moveTetrominoInsideBoard(Point[] rotatedPoints, int minCol, int maxCol) {
        if (minCol < 0) {
            for (int i = 0; i < 4; i++)
                rotatedPoints[i].addCol(-minCol);
        }
        else if (maxCol > Board.MAX_COL) {
            for (int i = 0; i < 4; i++)
                rotatedPoints[i].addCol(Board.MAX_COL - maxCol);
        }
    }

    public Point[] getPoints() {
        return points;
    }

    public Point[] moveRight() {
        centerPoint.addCol(1);
        for (int i = 0; i < 4; i++) {
            points[i].addCol(1);
            if (points[i].getCol() > Board.MAX_COL || checkPointOverlappingLine(points[i])) {
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
            if (points[i].getRow() > Board.MAX_ROW || checkPointOverlappingLine(points[i])) {
                centerPoint.addRow(-1);
                for (; i >= 0; i--)
                    points[i].addRow(-1);
                return null;
            }
        }
        return points;
    }

    public Point[] drop() {
        boolean[][] brd = board.getBoard();
        int minDistance = 20;
        int tempDistance;
        int row, col;

        for (Point point : points) {
            tempDistance = 1;
            row = point.getRow();
            col = point.getCol();
            while (row + tempDistance <= Board.MAX_ROW && !brd[row + tempDistance][col])
                tempDistance++;
            minDistance = Math.min(minDistance, tempDistance - 1);
        }

        if (minDistance == 0)
            return points;

        centerPoint.addRow(minDistance);
        for (Point point : points)
            point.addRow(minDistance);

        return points;
    }

    private boolean checkPointOverlappingLine(Point point) {
        return board.getBoard()[point.getRow()][point.getCol()];
    }

    private boolean checkTetrominoOverlappingLine(Point[] points) {
        boolean[][] brd = board.getBoard();

        for (Point point : points) {
            if (brd[point.getRow()][point.getCol()])
                return true;
        }
        return false;
    }
}
