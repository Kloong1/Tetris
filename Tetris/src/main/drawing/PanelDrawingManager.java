package main.drawing;

import main.frame.PlayerStatusPanel;
import main.frame.TetrisBoardPanel;
import main.tetromino.Tetromino;

public class PanelDrawingManager {
    private final TetrisBoardPanel tetrisBoardPanel;
    private final PlayerStatusPanel playerStatusPanel;

    public PanelDrawingManager(TetrisBoardPanel tetrisBoardPanel, PlayerStatusPanel playerStatusPanel) {
        this.tetrisBoardPanel = tetrisBoardPanel;
        this.playerStatusPanel = playerStatusPanel;

    }

    public void eraseTetrominoFromBoardPanel(Tetromino tetromino) {
        tetrisBoardPanel.erasePointsFromBlockPanels(tetromino.getPoints());
    }

    public void drawTetrominoOnBoardPanel(Tetromino tetromino) {
        tetrisBoardPanel.colorPointsOnBlockPanels(tetromino.getPoints(), tetromino.getColor());
    }

    public void drawLinesOnBoardPanel() {
        tetrisBoardPanel.colorLinesOnBlockPanels();
    }

    public void updatePlayerStatusPanel(int score, int combo, Tetromino nextTetromino) {
        playerStatusPanel.updatePlayerStatus(score, combo, nextTetromino);
    }

    public void colorBoardPanelForGameOver() {
        tetrisBoardPanel.colorBlockPanelsForGameOver();
        tetrisBoardPanel.repaint();
        tetrisBoardPanel.revalidate();
    }
}
