package controller;

import board.TetrisBoard;
import drawing.PanelDrawingManager;
import tetromino.Tetromino;

public class TetrisController {
    private final TetrisBoard tetrisBoard;
    private final TetrominoGenerator tetrominoGenerator;
    private final ScoreManager scoreManager;
    private final PanelDrawingManager panelDrawingManager;
    private Tetromino tetromino;

    private boolean gameOver = false;

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
        panelDrawingManager.eraseTetrominoFromBoardPanel(tetromino);
        tetromino.moveLeft();
        panelDrawingManager.drawTetrominoOnBoardPanel(tetromino);
    }

    public void moveTetrominoRight() {
        panelDrawingManager.eraseTetrominoFromBoardPanel(tetromino);
        tetromino.moveRight();
        panelDrawingManager.drawTetrominoOnBoardPanel(tetromino);
    }

    public void moveTetrominoDown() {
        panelDrawingManager.eraseTetrominoFromBoardPanel(tetromino);
        if (tetromino.moveDown() == null) {
            tetrisBoard.drawDroppedTetromino(tetromino.getPoints());
            scoreManager.updateScoreAndCombo(tetrisBoard.clearLine());
            panelDrawingManager.drawLinesOnBoardPanel();
            panelDrawingManager.updatePlayerStatusPanel(scoreManager.getScore(), scoreManager.getCombo(), tetrominoGenerator.peekNextTetromino());
            getNextTetromino();
        }
        if (!gameOver)
            panelDrawingManager.drawTetrominoOnBoardPanel(tetromino);
    }

    public void dropTetromino() {
        panelDrawingManager.eraseTetrominoFromBoardPanel(tetromino);
        tetrisBoard.drawDroppedTetromino(tetromino.drop());
        scoreManager.updateScoreAndCombo(tetrisBoard.clearLine());
        panelDrawingManager.drawLinesOnBoardPanel();
        panelDrawingManager.updatePlayerStatusPanel(scoreManager.getScore(), scoreManager.getCombo(), tetrominoGenerator.peekNextTetromino());
        getNextTetromino();
        if (!gameOver)
            panelDrawingManager.drawTetrominoOnBoardPanel(tetromino);
    }

    public void rotateClockwiseTetromino() {
        panelDrawingManager.eraseTetrominoFromBoardPanel(tetromino);
        tetromino.rotateClockwise();
        panelDrawingManager.drawTetrominoOnBoardPanel(tetromino);
    }

    public void rotateAnticlockwiseTetromino() {
        panelDrawingManager.eraseTetrominoFromBoardPanel(tetromino);
        tetromino.rotateAnticlockwise();
        panelDrawingManager.drawTetrominoOnBoardPanel(tetromino);
    }

    private void getNextTetromino() {
        tetromino = tetrominoGenerator.getTetromino();
        if (tetrisBoard.checkTetrominoOverlappingLine(tetromino.getPoints()))
            makeGameOver();
    }

    private void makeGameOver() {
        gameOver = true;
        panelDrawingManager.colorBoardPanelForGameOver();
    }
}
