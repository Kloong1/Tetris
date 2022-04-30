package frame;

import controller.TetrisController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TetrisFrame extends JFrame {
    private final TetrisController tetrisController;

    private final static int WIDTH = 1280;
    private final static int HEIGHT = 720;

    private final static int CONTAINER_PADDING = 15;
    private final static int PLAYER_ENEMY_GAP = 15;

    private JPanel mainPanel;

    public TetrisFrame(TetrisController tetrisController) {
        this.tetrisController = tetrisController;

        initMainPanel();

        initPlayerPanel();
        initEnemyPanel();

        initFrame();
    }

    private void initMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(CONTAINER_PADDING, CONTAINER_PADDING, CONTAINER_PADDING, CONTAINER_PADDING));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        getContentPane().add(mainPanel);
    }

    private void initFrame() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initPlayerPanel() {
        JPanel playerPanel = new JPanel();
        playerPanel.setBackground(Color.LIGHT_GRAY);
//        initPlayerTetrisBoard(playerPanel);
        mainPanel.add(playerPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(PLAYER_ENEMY_GAP, mainPanel.getHeight())));
    }

    private void initPlayerTetrisBoard(JPanel playerPanel) {
        JPanel playerTetrisBoard = new JPanel();
        playerTetrisBoard.setLayout(new GridLayout(20, 10));
        playerTetrisBoard.setBackground(Color.BLACK);

        JPanel[][] tetrisBoardPanels = new JPanel[10][20];
        playerPanel.add(playerTetrisBoard);
    }

    private void initEnemyPanel() {
        JPanel enemyPanel = new JPanel();
        enemyPanel.setBackground(Color.BLACK);
        mainPanel.add(enemyPanel);
    }
}
