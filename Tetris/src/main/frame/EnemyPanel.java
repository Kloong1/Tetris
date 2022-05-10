package frame;

import board.TetrisBoard;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EnemyPanel extends JPanel {
    private static final int PANEL_PADDING = 15;

    private TetrisBoardPanel tetrisBoardPanel;

    public EnemyPanel(TetrisBoardPanel tetrisBoardPanel) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(new EmptyBorder(PANEL_PADDING, PANEL_PADDING, PANEL_PADDING, PANEL_PADDING));
        setBackground(Color.BLUE);
        add(tetrisBoardPanel);
    }
}
