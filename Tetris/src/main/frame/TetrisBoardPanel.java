package frame;

import board.TetrisBoard;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TetrisBoardPanel extends JPanel {

    private final static int BLOCK_BORDER_THICKNESS = 1;
    private final static Color DEFAULT_BLOCK_COLOR = Color.LIGHT_GRAY;

    private final static int BOARD_BORDER_THICKNESS = 5;

    private JPanel[][] blockPanels;

    public TetrisBoardPanel() {
        super();
        setBorder(new LineBorder(Color.BLACK, BOARD_BORDER_THICKNESS));
        setLayout(new GridLayout(TetrisBoard.MAX_ROW + 1, TetrisBoard.MAX_COL + 1, 0, 0));
        setBackground(Color.LIGHT_GRAY);
        initBlockPanels();
    }

    private void initBlockPanels() {
        blockPanels = new JPanel[TetrisBoard.MAX_ROW + 1][TetrisBoard.MAX_COL + 1];

        for (int row = 0; row <= TetrisBoard.MAX_ROW; row++) {
            for (int col = 0; col <= TetrisBoard.MAX_COL; col++) {
                JPanel blockPanel = new JPanel();
                blockPanel.setBackground(DEFAULT_BLOCK_COLOR);
                blockPanel.setBorder(new LineBorder(Color.GRAY, BLOCK_BORDER_THICKNESS));
                blockPanels[row][col] = blockPanel;
                this.add(blockPanel);
            }
        }
    }

    public void colorBlockPanels(point.Point[] points, Color color) {
        for (point.Point point : points) {
            blockPanels[point.getRow()][point.getCol()].setBackground(color);
        }
    }

    public void eraseBlockPanels(point.Point[] points) {
        colorBlockPanels(points, DEFAULT_BLOCK_COLOR);
    }
}
