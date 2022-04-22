package tetromino;

import point.Point;

public abstract class Tetromino {

    protected int rotateIdx;
    protected Point point;

    public Tetromino() {
        this.rotateIdx = 0;
        this.point = new Point(0, 5);
    }

    abstract Point[] rotateClockwise();
    abstract Point[] rotateAnticlockwise();

    abstract Point[] moveRight();
    abstract Point[] moveLeft();
    abstract Point[] moveDown();
    abstract Point[] drop();
}
