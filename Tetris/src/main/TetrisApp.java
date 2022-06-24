package main;

import main.board.TetrisBoard;
import main.controller.TetrisDifficultyControlTimer;
import main.controller.TetrominoMoveDownThread;
import main.drawing.PanelDrawingManager;
import main.controller.TetrisController;
import main.frame.*;

public class TetrisApp {
    public static void main(String[] args) {
        TetrisBoard playerTetrisBoard = new TetrisBoard();
        TetrisBoardPanel playerTetrisBoardPanel = new TetrisBoardPanel(playerTetrisBoard);
        PlayerStatusPanel playerStatusPanel = new PlayerStatusPanel();
        PlayerPanel playerPanel = new PlayerPanel(playerTetrisBoardPanel, playerStatusPanel);

        TetrisBoard enemyTetrisBoard = new TetrisBoard();
        TetrisBoardPanel enemyTetrisBoardPanel = new TetrisBoardPanel(enemyTetrisBoard);
        EnemyPanel enemyPanel = new EnemyPanel(enemyTetrisBoardPanel);

        PanelDrawingManager playerPanelDrawingManager = new PanelDrawingManager(playerTetrisBoardPanel, playerStatusPanel);

        TetrisController tetrisController = new TetrisController(playerPanelDrawingManager, playerTetrisBoard);

        new TetrisFrame(tetrisController, playerPanel, enemyPanel);

        TetrominoMoveDownThread tetrominoMoveDownThread = new TetrominoMoveDownThread(tetrisController);
        tetrominoMoveDownThread.start();

        new TetrisDifficultyControlTimer(tetrominoMoveDownThread).start();
    }
}
