package controller;

import board.TetrisBoard;
import point.Point;
import tetromino.Tetromino;

import java.awt.*;

public class TetrisController {
    private final TetrisBoard tetrisBoard;
    private final TetrominoGenerator tetrominoGenerator;
    private final ScoreManager scoreManager;
    private Tetromino tetromino;

    private boolean gameOver = false;

    public TetrisController() {
        this.tetrisBoard = new TetrisBoard();
        this.scoreManager = new ScoreManager();
        tetrominoGenerator = new TetrominoGenerator(tetrisBoard);
        tetromino = tetrominoGenerator.getTetromino();
    }

    public TetrisBoard getBoard() {
        return tetrisBoard;
    }

    public Point[] getTetrominoPoints() {
        return tetromino.getPoints();
    }

    public Color getTetrominoColor() {
        return tetromino.getColor();
    }

    public Tetromino peekNextTetromino() {
        return tetrominoGenerator.peekNextTetromino();
    }

    public int getScore() {
        return scoreManager.getScore();
    }

    public int getCombo() {
        return scoreManager.getCombo();
    }

    public boolean isGameOver() {
        return gameOver;
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
            scoreManager.updateScoreAndCombo(tetrisBoard.clearLine());
            getNextTetromino();
            return null;
        }
        else
            return tetromino.getPoints();
    }

    public void dropTetromino() {
        tetrisBoard.drawDroppedTetromino(tetromino.drop());
        scoreManager.updateScoreAndCombo(tetrisBoard.clearLine());
        getNextTetromino();
    }

    public Point[] rotateClockwiseTetromino() {
        return tetromino.rotateClockwise();
    }

    public Point[] rotateAnticlockwiseTetromino() {
        return tetromino.rotateAnticlockwise();
    }

    private void getNextTetromino() {
        tetromino = tetrominoGenerator.getTetromino();
        if (tetrisBoard.checkTetrominoOverlappingLine(tetromino.getPoints()))
            gameOver = true;
    }

}
