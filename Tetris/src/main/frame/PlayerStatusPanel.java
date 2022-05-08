package frame;

import controller.TetrisController;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
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
}
