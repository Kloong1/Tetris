package tetromino;

import board.TetrisBoard;
import point.Point;

public class TetrominoS extends Tetromino{

    private final static Point[][] BLOCKS_S;

    static {
        BLOCKS_S = new Point[4][4];
        initBlocksS();
    }

    public TetrominoS(TetrisBoard tetrisBoard) {
        super(tetrisBoard);
        blocks = BLOCKS_S;
        initPoints();
    }

    private static void initBlocksS() {
        BLOCKS_S[0] = new Point[]
                {new Point(0, 0), new Point(0, -1), new Point(-1, 0), new Point(-1, 1)};

        BLOCKS_S[1] = new Point[]
                {new Point(0, 0), new Point(-1, 0), new Point(0, 1), new Point(1, 1)};

        BLOCKS_S[2] = new Point[]
                {new Point(0, 0), new Point(1, 0), new Point(1, -1), new Point(0, 1)};

        BLOCKS_S[3] = new Point[]
                {new Point(0, 0), new Point(0, -1), new Point(-1, -1), new Point(1, 0)};
    }
}
