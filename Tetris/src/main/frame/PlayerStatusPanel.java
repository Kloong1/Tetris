package main.frame;

import main.controller.TetrisController;
import main.tetromino.Tetromino;

import javax.swing.*;
import java.awt.*;

public class PlayerStatusPanel extends JPanel {

    public final static int WIDTH = 250;
    private final static int PANEL_GAP = 30;

    private final PlayerScorePanel scorePanel;
    private final PlayerComboPanel comboPanel;
    private final PlayerNextTetrominoPanel nextTetrominoPanel;

    public PlayerStatusPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(CENTER_ALIGNMENT);

        scorePanel = new PlayerScorePanel();
        comboPanel = new PlayerComboPanel();
        nextTetrominoPanel = new PlayerNextTetrominoPanel();

        add(scorePanel);
        add(Box.createRigidArea(new Dimension(0, PANEL_GAP)));
        add(comboPanel);
        add(Box.createRigidArea(new Dimension(0, PANEL_GAP)));
        add(nextTetrominoPanel);
    }

    public PlayerStatusPanel(boolean isEnemyPanel) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(CENTER_ALIGNMENT);

        scorePanel = new PlayerScorePanel();
        comboPanel = new PlayerComboPanel();

        add(scorePanel);
        add(Box.createRigidArea(new Dimension(0, PANEL_GAP)));
        add(comboPanel);

        if (isEnemyPanel) {
            nextTetrominoPanel = null;
        }
        else {
            nextTetrominoPanel = new PlayerNextTetrominoPanel();
            add(Box.createRigidArea(new Dimension(0, PANEL_GAP)));
            add(nextTetrominoPanel);
        }
    }

    public void updatePlayerStatus(int score, int combo, Tetromino nextTetromino) {
        updateScore(score);
        updateCombo(combo);
        updateNextTetromino(nextTetromino);
    }

    public void updateEnemyPlayerStatus(int score, int combo) {
        updateScore(score);
        updateCombo(combo);
    }

    private void updateScore(int score) {
        scorePanel.setScore(score);
    }

    private void updateCombo(int combo) {
        comboPanel.setCombo(combo);
    }

    private void updateNextTetromino(Tetromino nextTetromino) {
        nextTetrominoPanel.setNextTetromino(nextTetromino);
    }
}
