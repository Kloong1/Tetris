package main.controller;

import main.board.TetrisBoard;
import main.drawing.PanelDrawingManager;
import main.tetromino.Tetromino;

import java.util.concurrent.locks.ReentrantLock;

public class TetrisController {
    private final TetrisBoard tetrisBoard;
    private final TetrominoGenerator tetrominoGenerator;
    private final ScoreManager scoreManager;
    private final PanelDrawingManager panelDrawingManager;
    private Tetromino tetromino;

    private boolean gameOver = false;

    private final ReentrantLock controllerLock = new ReentrantLock();

    public TetrisController(PanelDrawingManager panelDrawingManager, TetrisBoard tetrisBoard) {
        this.panelDrawingManager = panelDrawingManager;
        this.tetrisBoard = tetrisBoard;

        this.scoreManager = new ScoreManager();
        tetrominoGenerator = new TetrominoGenerator(tetrisBoard);
        tetromino = tetrominoGenerator.getTetromino();

        panelDrawingManager.drawTetrominoOnBoardPanel(tetromino);
        panelDrawingManager.updatePlayerStatusPanel(scoreManager.getScore(), scoreManager.getCombo(), tetrominoGenerator.peekNextTetromino());
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void moveTetrominoLeft() {
        controllerLock.lock();
        panelDrawingManager.eraseTetrominoFromBoardPanel(tetromino);
        tetromino.moveLeft();
        panelDrawingManager.drawTetrominoOnBoardPanel(tetromino);
        controllerLock.unlock();
    }

    public void moveTetrominoRight() {
        controllerLock.lock();
        panelDrawingManager.eraseTetrominoFromBoardPanel(tetromino);
        tetromino.moveRight();
        panelDrawingManager.drawTetrominoOnBoardPanel(tetromino);
        controllerLock.unlock();
    }

    public void moveTetrominoDown() {
        controllerLock.lock();
        panelDrawingManager.eraseTetrominoFromBoardPanel(tetromino);
        if (tetromino.moveDown() == null) {
            tetrisBoard.drawDroppedTetromino(tetromino.getPoints());
            scoreManager.updateScoreAndCombo(tetrisBoard.clearLine());
            panelDrawingManager.drawLinesOnBoardPanel();
            getNextTetromino();
            panelDrawingManager.updatePlayerStatusPanel(scoreManager.getScore(), scoreManager.getCombo(), tetrominoGenerator.peekNextTetromino());
        }
        if (!gameOver)
            panelDrawingManager.drawTetrominoOnBoardPanel(tetromino);
        controllerLock.unlock();
    }

    public void dropTetromino() {
        controllerLock.lock();
        panelDrawingManager.eraseTetrominoFromBoardPanel(tetromino);
        tetrisBoard.drawDroppedTetromino(tetromino.drop());
        scoreManager.updateScoreAndCombo(tetrisBoard.clearLine());
        panelDrawingManager.drawLinesOnBoardPanel();
        getNextTetromino();
        panelDrawingManager.updatePlayerStatusPanel(scoreManager.getScore(), scoreManager.getCombo(), tetrominoGenerator.peekNextTetromino());
        if (!gameOver)
            panelDrawingManager.drawTetrominoOnBoardPanel(tetromino);
        controllerLock.unlock();
    }

    public void rotateClockwiseTetromino() {
        controllerLock.lock();
        panelDrawingManager.eraseTetrominoFromBoardPanel(tetromino);
        tetromino.rotateClockwise();
        panelDrawingManager.drawTetrominoOnBoardPanel(tetromino);
        controllerLock.unlock();
    }

    public void rotateAnticlockwiseTetromino() {
        controllerLock.lock();
        panelDrawingManager.eraseTetrominoFromBoardPanel(tetromino);
        tetromino.rotateAnticlockwise();
        panelDrawingManager.drawTetrominoOnBoardPanel(tetromino);
        controllerLock.unlock();
    }

    private void getNextTetromino() {
        controllerLock.lock();
        tetromino = tetrominoGenerator.getTetromino();
        if (tetrisBoard.checkTetrominoOverlappingLine(tetromino.getPoints()))
            makeGameOver();
        controllerLock.unlock();
    }

    private void makeGameOver() {
        controllerLock.lock();
        gameOver = true;
        panelDrawingManager.colorBoardPanelForGameOver();
        controllerLock.unlock();
    }
}
