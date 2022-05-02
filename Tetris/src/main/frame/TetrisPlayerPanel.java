package frame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TetrisPlayerPanel extends JPanel {

    private static final int PANEL_PADDING = 15;

    private TetrisBoardPanel tetrisBoardPanel;
    private PlayerStatusPanel playerStatusPanel;

    public TetrisPlayerPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(new EmptyBorder(PANEL_PADDING, PANEL_PADDING, PANEL_PADDING, PANEL_PADDING));
        setBackground(Color.ORANGE);
        addTetrisBoardPanel();
        addPlayerStatusPanel();
    }

    private void addTetrisBoardPanel() {
        tetrisBoardPanel = new TetrisBoardPanel();
        add(tetrisBoardPanel);
    }

    private void addPlayerStatusPanel() {
        playerStatusPanel = new PlayerStatusPanel();
        playerStatusPanel.setSize(300, 600);
        playerStatusPanel.setBackground(Color.LIGHT_GRAY);
        add(playerStatusPanel);
    }
}
