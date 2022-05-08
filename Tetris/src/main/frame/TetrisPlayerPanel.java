package frame;

import board.TetrisBoard;
import controller.TetrisController;
import keyaction.PlayerKeyAction;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TetrisPlayerPanel extends JPanel {
    private static final int PANEL_PADDING = 15;
    private static final int BOARD_STATUS_GAP = 15;

    private final TetrisController tetrisController;
    private TetrisBoardPanel tetrisBoardPanel;
    private PlayerStatusPanel playerStatusPanel;

    public TetrisPlayerPanel(TetrisController tetrisController) {
        this.tetrisController = tetrisController;

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(new EmptyBorder(PANEL_PADDING, PANEL_PADDING, PANEL_PADDING, PANEL_PADDING));
        setBackground(Color.ORANGE);

        addTetrisBoardPanel(tetrisController.getBoard());
        add(Box.createRigidArea(new Dimension(BOARD_STATUS_GAP, 0)));
        addPlayerStatusPanel();

        initKeyBindings();

        //draw first tetromino
        tetrisBoardPanel.colorTetrominoOnBlockPanels(tetrisController.getTetrominoPoints(), tetrisController.getTetrominoColor());
    }

    private void addTetrisBoardPanel(TetrisBoard tetrisBoard) {
        tetrisBoardPanel = new TetrisBoardPanel(tetrisBoard);
        add(tetrisBoardPanel);
    }

    private void addPlayerStatusPanel() {
        playerStatusPanel = new PlayerStatusPanel(tetrisController);
        add(playerStatusPanel);
    }

    private void initKeyBindings() {
        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);

        inputMap.put(KeyStroke.getKeyStroke("LEFT"), PlayerKeyAction.MOVE_LEFT);
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), PlayerKeyAction.MOVE_RIGHT);
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), PlayerKeyAction.MOVE_DOWN);
        inputMap.put(KeyStroke.getKeyStroke("SPACE"), PlayerKeyAction.DROP);

        inputMap.put(KeyStroke.getKeyStroke("UP"), PlayerKeyAction.ROTATE_CLOCKWISE);
        inputMap.put(KeyStroke.getKeyStroke("Z"), PlayerKeyAction.ROTATE_CLOCKWISE);
        inputMap.put(KeyStroke.getKeyStroke("X"), PlayerKeyAction.ROTATE_ANTICLOCKWISE);

        ActionMap actionMap = getActionMap();

        actionMap.put(PlayerKeyAction.MOVE_LEFT, new PlayerKeyAction(PlayerKeyAction.MOVE_LEFT, tetrisBoardPanel, playerStatusPanel, tetrisController));
        actionMap.put(PlayerKeyAction.MOVE_RIGHT, new PlayerKeyAction(PlayerKeyAction.MOVE_RIGHT, tetrisBoardPanel, playerStatusPanel, tetrisController));
        actionMap.put(PlayerKeyAction.MOVE_DOWN, new PlayerKeyAction(PlayerKeyAction.MOVE_DOWN, tetrisBoardPanel, playerStatusPanel, tetrisController));
        actionMap.put(PlayerKeyAction.DROP, new PlayerKeyAction(PlayerKeyAction.DROP, tetrisBoardPanel, playerStatusPanel, tetrisController));

        actionMap.put(PlayerKeyAction.ROTATE_CLOCKWISE, new PlayerKeyAction(PlayerKeyAction.ROTATE_CLOCKWISE, tetrisBoardPanel, playerStatusPanel, tetrisController));
        actionMap.put(PlayerKeyAction.ROTATE_ANTICLOCKWISE, new PlayerKeyAction(PlayerKeyAction.ROTATE_ANTICLOCKWISE, tetrisBoardPanel, playerStatusPanel, tetrisController));
    }
}
