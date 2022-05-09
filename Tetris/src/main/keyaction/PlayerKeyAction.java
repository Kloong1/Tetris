package keyaction;

import controller.TetrisController;
import frame.PlayerStatusPanel;
import frame.TetrisBoardPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PlayerKeyAction extends AbstractAction {

    public static final String MOVE_DOWN = "md";
    public static final String MOVE_LEFT = "ml";
    public static final String MOVE_RIGHT = "mr";
    public static final String DROP = "dr";

    public static final String ROTATE_CLOCKWISE = "rc";
    public static final String ROTATE_ANTICLOCKWISE = "race";

    private final TetrisBoardPanel tetrisBoardPanel;
    private final PlayerStatusPanel playerStatusPanel;
    private final TetrisController tetrisController;

    private final String key;

    public PlayerKeyAction(String key, TetrisBoardPanel tetrisBoardPanel, PlayerStatusPanel playerStatusPanel, TetrisController tetrisController) {
        this.key = key;
        this.tetrisBoardPanel = tetrisBoardPanel;
        this.playerStatusPanel = playerStatusPanel;
        this.tetrisController = tetrisController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (key) {
            case MOVE_LEFT -> moveTetrominoLeft();
            case MOVE_RIGHT -> moveTetrominoRight();
            case MOVE_DOWN -> moveTetrominoDown();
            case DROP -> dropTetromino();
            case ROTATE_CLOCKWISE -> rotateClockwiseTetromino();
            case ROTATE_ANTICLOCKWISE -> rotateAnticlockwiseTetromino();
        }
    }

    private void moveTetrominoRight() {
        tetrisBoardPanel.eraseTetrominoFromBlockPanels(tetrisController.getTetrominoPoints());
        tetrisBoardPanel.colorTetrominoOnBlockPanels(tetrisController.moveTetrominoRight(), tetrisController.getTetrominoColor());
    }

    private void moveTetrominoLeft() {
        tetrisBoardPanel.eraseTetrominoFromBlockPanels(tetrisController.getTetrominoPoints());
        tetrisBoardPanel.colorTetrominoOnBlockPanels(tetrisController.moveTetrominoLeft(), tetrisController.getTetrominoColor());
    }

    private void moveTetrominoDown() {
        tetrisBoardPanel.eraseTetrominoFromBlockPanels(tetrisController.getTetrominoPoints());
        if (tetrisController.moveTetrominoDown() == null) {
            tetrisBoardPanel.colorLinesOnBlockPanels();
            playerStatusPanel.updatePlayerStatus();
        }
        tetrisBoardPanel.colorTetrominoOnBlockPanels(tetrisController.getTetrominoPoints(), tetrisController.getTetrominoColor());
    }

    private void dropTetromino() {
        tetrisBoardPanel.eraseTetrominoFromBlockPanels(tetrisController.getTetrominoPoints());
        tetrisController.dropTetromino();
        tetrisBoardPanel.colorLinesOnBlockPanels();
        tetrisBoardPanel.colorTetrominoOnBlockPanels(tetrisController.getTetrominoPoints(), tetrisController.getTetrominoColor());
        playerStatusPanel.updatePlayerStatus();
    }

    private void rotateClockwiseTetromino() {
        tetrisBoardPanel.eraseTetrominoFromBlockPanels(tetrisController.getTetrominoPoints());
        tetrisBoardPanel.colorTetrominoOnBlockPanels(tetrisController.rotateClockwiseTetromino(), tetrisController.getTetrominoColor());
    }

    private void rotateAnticlockwiseTetromino() {
        tetrisBoardPanel.eraseTetrominoFromBlockPanels(tetrisController.getTetrominoPoints());
        tetrisBoardPanel.colorTetrominoOnBlockPanels(tetrisController.rotateAnticlockwiseTetromino(), tetrisController.getTetrominoColor());
    }

}
