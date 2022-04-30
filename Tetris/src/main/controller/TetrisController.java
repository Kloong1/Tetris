package controller;

import board.TetrisBoard;
import score.ScoreManager;
import tetromino.Tetromino;

public class TetrisController {
    private final TetrisBoard tetrisBoard;
    private final TetrominoGenerator tetrominoGenerator;
    private final ScoreManager scoreManager;
    private Tetromino tetromino;

    public TetrisController() {
        this.tetrisBoard = new TetrisBoard();
        this.scoreManager = new ScoreManager();
        tetrominoGenerator = new TetrominoGenerator(tetrisBoard);
        tetromino = tetrominoGenerator.getTetromino();
    }

    public TetrisBoard getBoard() {
        return tetrisBoard;
    }

    public int getScore() {
        return scoreManager.getScore();
    }

    public int getCombo() {
        return scoreManager.getCombo();
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
        tetromino = tetrominoGenerator.getTetromino();
    }
}
