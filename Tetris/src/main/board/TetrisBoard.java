package board;

import java.io.Serializable;
import java.util.Arrays;

public class TetrisBoard implements Serializable {

    public static final transient int MAX_COL = 9;
    public static final transient int MAX_ROW = 19;

    private final boolean[][] board = new boolean[MAX_ROW + 1][MAX_COL + 1];

    public boolean[][] getBoard() {
        return board;
    }

    public int clearLine() {
        int clearedLines = 0;

        for (int row = MAX_ROW; row >= 0; row--) {
            if (isLineFilled(board[row])) {
                clearedLines++;
                Arrays.fill(board[row], false);
            }
            else if (clearedLines > 0) {
                moveDownLine(row, clearedLines);
            }
        }

        return clearedLines;
    }

    private void moveDownLine(int lineIdx, int clearedLines) {
        System.arraycopy(board[lineIdx], 0, board[lineIdx + clearedLines], 0, MAX_COL);
    }

    private boolean isLineFilled(boolean[] line) {
        for (boolean block : line)
            if (!block)
                return false;
        return true;
    }
}
