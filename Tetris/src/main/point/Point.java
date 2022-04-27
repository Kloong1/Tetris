package point;

import java.util.Objects;

public class Point {
    private int row;
    private int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
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

    //for test
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;

        Point p = (Point)o;
        return this.row == p.row && this.col == p.col;
    }

    //for test
    @Override
    public String toString() {
        return "Point{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
