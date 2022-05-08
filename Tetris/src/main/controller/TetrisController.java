package controller;

import board.TetrisBoard;
import point.Point;
import score.ScoreManager;
import tetromino.Tetromino;

import java.awt.*;

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

    public Tetromino getTetromino() {
        return tetromino;
    }

    public Point[] getTetrominoPoints() {
        return tetromino.getPoints();
    }

    public Color getTetrominoColor() {
        return tetromino.getColor();
    }

    public int getScore() {
        return scoreManager.getScore();
    }

    public int getCombo() {
        return scoreManager.getCombo();
    }

    public Point[] moveTetrominoLeft() {
        return tetromino.moveLeft();
    }

    public Point[] moveTetrominoRight() {
        return tetromino.moveRight();
    }

    public Point[] moveTetrominoDown() {
        if (tetromino.moveDown() == null) {
            tetrisBoard.drawDroppedTetromino(tetromino.getPoints());
            tetrisBoard.clearLine();
            tetromino = tetrominoGenerator.getTetromino();
            return null;
        }
        else
            return tetromino.getPoints();
    }

    public void dropTetromino() {
        tetrisBoard.drawDroppedTetromino(tetromino.drop());
        tetrisBoard.clearLine();
        tetromino = tetrominoGenerator.getTetromino();
    }

    public Point[] rotateClockwiseTetromino() {
        return tetromino.rotateClockwise();
    }

    public Point[] rotateAnticlockwiseTetromino() {
        return tetromino.rotateAnticlockwise();
    }

}
