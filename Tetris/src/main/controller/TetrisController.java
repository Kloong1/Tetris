package controller;

import board.Board;
import score.ScoreManager;
import tetromino.Tetromino;

public class TetrisController {
    private final Board board;
    private final TetrominoGenerator tetrominoGenerator;
    private final ScoreManager scoreManager;
    private Tetromino tetromino;

    public TetrisController(Board board, ScoreManager scoreManager) {
        this.board = board;
        this.scoreManager = scoreManager;
        tetrominoGenerator = new TetrominoGenerator(board);
        tetromino = tetrominoGenerator.getNextTetromino();
    }

    public void moveTetrominoLeft() {
        tetromino.moveLeft();
    }

    public void moveTetrominoRight() {
        tetromino.moveRight();
    }

    public void moveTetrominoDown() {
        tetromino.moveDown();
    }

    public void dropTetromino() {
        tetromino.drop();
        tetromino = tetrominoGenerator.getNextTetromino();
    }
}
