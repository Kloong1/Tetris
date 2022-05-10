package frame;

import controller.TetrisController;
import tetromino.Tetromino;

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

    public void updatePlayerStatus(int score, int combo, Tetromino nextTetromino) {
        updateScore(score);
        updateCombo(combo);
        updateNextTetromino(nextTetromino);
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
