package frame;

import controller.TetrisController;
import keyaction.PlayerKeyAction;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TetrisFrame extends JFrame {

    private final static int WIDTH = 1100;
    private final static int HEIGHT = 700;

    private final static int CONTAINER_PADDING = 15;
    private final static int PLAYER_ENEMY_GAP = 15;

    private final TetrisController tetrisController;
    private final JPanel mainPanel;

    public TetrisFrame(TetrisController tetrisController, PlayerPanel playerPanel, EnemyPanel enemyPanel) {
        this.tetrisController = tetrisController;

        mainPanel = new JPanel();
        initMainPanel(playerPanel, enemyPanel);
        initMainPanelKeyBindings();
        getContentPane().add(mainPanel);

        initFrame();
    }

    private void initFrame() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initMainPanel(PlayerPanel playerPanel, EnemyPanel enemyPanel) {
        mainPanel.setBorder(new EmptyBorder(CONTAINER_PADDING, CONTAINER_PADDING, CONTAINER_PADDING, CONTAINER_PADDING));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        mainPanel.add(playerPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(PLAYER_ENEMY_GAP, 0)));
        mainPanel.add(enemyPanel);
    }

    private void initMainPanelKeyBindings() {
        InputMap inputMap = mainPanel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);

        inputMap.put(KeyStroke.getKeyStroke("LEFT"), PlayerKeyAction.MOVE_LEFT);
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), PlayerKeyAction.MOVE_RIGHT);
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), PlayerKeyAction.MOVE_DOWN);
        inputMap.put(KeyStroke.getKeyStroke("SPACE"), PlayerKeyAction.DROP);

        inputMap.put(KeyStroke.getKeyStroke("UP"), PlayerKeyAction.ROTATE_CLOCKWISE);
        inputMap.put(KeyStroke.getKeyStroke("Z"), PlayerKeyAction.ROTATE_CLOCKWISE);
        inputMap.put(KeyStroke.getKeyStroke("X"), PlayerKeyAction.ROTATE_ANTICLOCKWISE);

        ActionMap actionMap = mainPanel.getActionMap();

        actionMap.put(PlayerKeyAction.MOVE_LEFT, new PlayerKeyAction(PlayerKeyAction.MOVE_LEFT,tetrisController));
        actionMap.put(PlayerKeyAction.MOVE_RIGHT, new PlayerKeyAction(PlayerKeyAction.MOVE_RIGHT, tetrisController));
        actionMap.put(PlayerKeyAction.MOVE_DOWN, new PlayerKeyAction(PlayerKeyAction.MOVE_DOWN, tetrisController));
        actionMap.put(PlayerKeyAction.DROP, new PlayerKeyAction(PlayerKeyAction.DROP, tetrisController));

        actionMap.put(PlayerKeyAction.ROTATE_CLOCKWISE, new PlayerKeyAction(PlayerKeyAction.ROTATE_CLOCKWISE, tetrisController));
        actionMap.put(PlayerKeyAction.ROTATE_ANTICLOCKWISE, new PlayerKeyAction(PlayerKeyAction.ROTATE_ANTICLOCKWISE, tetrisController));
    }
}
