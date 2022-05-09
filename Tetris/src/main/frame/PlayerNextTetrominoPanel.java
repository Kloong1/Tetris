package frame;

import board.TetrisBoard;
import point.Point;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PlayerNextTetrominoPanel extends JPanel {
    private final static int WIDTH = 120;
    private final static int HEIGHT = 120;

    private static final String TITLE_STRING = "Next";
    private static final String FONT_NAME = "CookieRunOTF";
    private static final int TITlE_FONT_SIZE = 20;

    private final static int BLOCK_BORDER_THICKNESS = 1;
    private final static int BOARD_BORDER_THICKNESS = 3;
    private final static Color DEFAULT_BLOCK_COLOR = Color.WHITE;

    private JPanel boardPanel;
    private JPanel[][] blockPanels;

    public PlayerNextTetrominoPanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new TitledBorder(new EmptyBorder(1,1,1,1), TITLE_STRING,
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                new Font(FONT_NAME, Font.PLAIN, TITlE_FONT_SIZE)));

        initBoardPanel();
        add(boardPanel);
    }

    private void initBoardPanel() {
        boardPanel = new JPanel();
        boardPanel.setBorder(new LineBorder(Color.BLACK, BOARD_BORDER_THICKNESS));
        boardPanel.setLayout(new GridLayout(4, 4, 0, 0));
        boardPanel.setBackground(DEFAULT_BLOCK_COLOR);

        boardPanel.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        boardPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        boardPanel.setMaximumSize(new Dimension(WIDTH, HEIGHT));

        initBlockPanels();
    }

    private void initBlockPanels() {
        blockPanels = new JPanel[4][4];

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                JPanel blockPanel = new JPanel();
                blockPanel.setBackground(DEFAULT_BLOCK_COLOR);
                blockPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, BLOCK_BORDER_THICKNESS));
                blockPanels[row][col] = blockPanel;
                boardPanel.add(blockPanel);
            }
        }
    }

    public void setNextTetromino() {

    }
}
