package point;

import java.util.Objects;

public class Point {
    private int row;
    private int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Point(Point other) {
        this.row = other.row;
        this.col = other.col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void addRow(int row) {
        this.row += row;
    }

    public void addCol(int col) {
        this.col += col;
    }

//    @Override
//    protected Point clone(){
//        Object clone = null;
//        try {
//            clone = super.clone();
//        } catch (CloneNotSupportedException ignored) { }
//        return (Point)clone;
//    }
}
