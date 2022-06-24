package main.tetromino;

import main.board.TetrisBoard;
import main.point.Point;

import java.awt.*;

public class TetrominoT extends Tetromino{

    private final static Point[][] BLOCKS_T;

    static {
        BLOCKS_T = new Point[4][4];
        initBlocksT();
    }

    public TetrominoT(TetrisBoard tetrisBoard) {
        super(tetrisBoard);
        blocks = BLOCKS_T;
        color = Color.PINK;
        initPoints();
    }

    private static void initBlocksT() {
        BLOCKS_T[0] = new Point[]
                {new Point(0, 0), new Point(0, -1), new Point(-1, 0), new Point(0, 1)};

        BLOCKS_T[1] = new Point[]
                {new Point(0, 0), new Point(-1, 0), new Point(0, 1), new Point(1, 0)};

        BLOCKS_T[2] = new Point[]
                {new Point(0, 0), new Point(0, -1), new Point(1, 0), new Point(0, 1)};

        BLOCKS_T[3] = new Point[]
                {new Point(0, 0), new Point(-1, 0), new Point(0, -1), new Point(1, 0)};
    }
}
