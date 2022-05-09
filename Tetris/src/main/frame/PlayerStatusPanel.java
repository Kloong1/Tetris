package frame;

import controller.TetrisController;

import javax.swing.*;
import java.awt.*;

public class PlayerStatusPanel extends JPanel {

    public final static int WIDTH = 250;

    private final static int PANEL_GAP = 30;

    private final TetrisController tetrisController;

    private PlayerScorePanel scorePanel;
    private PlayerComboPanel comboPanel;
    private PlayerNextTetrominoPanel nextTetrominoPanel;

    public PlayerStatusPanel(TetrisController tetrisController) {
        this.tetrisController = tetrisController;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(CENTER_ALIGNMENT);

        initScorePanel();
        initComboPanel();
        initNextTetrominoPanel();

        add(scorePanel);
        add(Box.createRigidArea(new Dimension(0, PANEL_GAP)));
        add(comboPanel);
        add(Box.createRigidArea(new Dimension(0, PANEL_GAP)));
        add(nextTetrominoPanel);
    }

    private void initScorePanel() {
        scorePanel = new PlayerScorePanel();
    }

    private void initComboPanel() {
        comboPanel = new PlayerComboPanel();
    }

    private void initNextTetrominoPanel() {
        nextTetrominoPanel = new PlayerNextTetrominoPanel();
    }

    public void updatePlayerStatus() {
        updateScore();
        updateCombo();
        updateNextTetromino();
    }

    private void updateScore() {
        scorePanel.setScore(tetrisController.getScore());
    }

    private void updateCombo() {
        comboPanel.setCombo(tetrisController.getCombo());
    }

    private void updateNextTetromino() {
        //need parameter from tetrisController
        nextTetrominoPanel.setNextTetromino();
    }
}
