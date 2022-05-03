package frame;

import board.TetrisBoard;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TetrisEnemyPanel extends JPanel {
    private static final int PANEL_PADDING = 15;

    private TetrisBoardPanel tetrisBoardPanel;

    public TetrisEnemyPanel(TetrisBoard tetrisBoard) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(new EmptyBorder(PANEL_PADDING, PANEL_PADDING, PANEL_PADDING, PANEL_PADDING));
        setBackground(Color.BLUE);
        addTetrisBoardPanel(tetrisBoard);
    }

    private void addTetrisBoardPanel(TetrisBoard tetrisBoard) {
        tetrisBoardPanel = new TetrisBoardPanel(tetrisBoard);
        add(tetrisBoardPanel);
    }
}
