package main.point;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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

    public void addRow(int row) {
        this.row += row;
    }

    public void addCol(int col) {
        this.col += col;
    }
}
