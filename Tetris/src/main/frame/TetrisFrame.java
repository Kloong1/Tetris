package frame;

import board.TetrisBoard;
import controller.TetrisController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TetrisFrame extends JFrame {

    private final static int WIDTH = 1100;
    private final static int HEIGHT = 700;

    private final static int CONTAINER_PADDING = 15;
    private final static int PLAYER_ENEMY_GAP = 15;

    private final TetrisController tetrisController;

    private JPanel mainPanel;
    private TetrisPlayerPanel playerPanel;

    public TetrisFrame(TetrisController tetrisController) {
        this.tetrisController = tetrisController;
        initMainPanel();
        initFrame();
    }

    private void initMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(CONTAINER_PADDING, CONTAINER_PADDING, CONTAINER_PADDING, CONTAINER_PADDING));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        initPlayerPanel();
        mainPanel.add(Box.createRigidArea(new Dimension(PLAYER_ENEMY_GAP, 0)));
        initEnemyPanel();
        getContentPane().add(mainPanel);
    }

    private void initFrame() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initPlayerPanel() {
        playerPanel = new TetrisPlayerPanel(tetrisController);
        mainPanel.add(playerPanel);
    }

    private void initEnemyPanel() {
        JPanel enemyPanel = new TetrisEnemyPanel(new TetrisBoard());
        mainPanel.add(enemyPanel);
    }
}
