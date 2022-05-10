package frame;

import board.TetrisBoard;
import controller.TetrisController;
import keyaction.PlayerKeyAction;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PlayerPanel extends JPanel {
    private static final int PANEL_PADDING = 15;
    private static final int BOARD_STATUS_GAP = 15;

    public PlayerPanel(TetrisBoardPanel tetrisBoardPanel, PlayerStatusPanel playerStatusPanel) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(new EmptyBorder(PANEL_PADDING, PANEL_PADDING, PANEL_PADDING, PANEL_PADDING));
        setBackground(Color.ORANGE);

        add(tetrisBoardPanel);
        add(Box.createRigidArea(new Dimension(BOARD_STATUS_GAP, 0)));
        add(playerStatusPanel);
    }
}
