package board;

import java.io.Serializable;

public class Board implements Serializable {

    public static final transient int MAX_COL = 9;
    public static final transient int MAX_ROW = 19;

    private final boolean[][] board = new boolean[MAX_ROW + 1][MAX_COL + 1];

    public boolean[][] getBoard() {
        return board;
    }
}
