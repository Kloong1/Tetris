package main.frame;

import main.board.TetrisBoard;
import main.point.Point;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.GridLayout;

public class TetrisBoardPanel extends JPanel {

    private final static int BLOCK_BORDER_THICKNESS = 1;
    private final static int BOARD_BORDER_THICKNESS = 5;
    private final static Color DEFAULT_BLOCK_COLOR = Color.WHITE;
    private final static Color DEFAULT_LINE_COLOR = Color.GRAY;

    private final TetrisBoard tetrisBoard;
    private JPanel[][] blockPanels;

    public TetrisBoardPanel(TetrisBoard tetrisBoard) {
        super();
        this.tetrisBoard = tetrisBoard;
        setBorder(new LineBorder(Color.BLACK, BOARD_BORDER_THICKNESS));
        setLayout(new GridLayout(TetrisBoard.MAX_ROW + 1, TetrisBoard.MAX_COL + 1, 0, 0));
        setBackground(DEFAULT_BLOCK_COLOR);
        initBlockPanels();
    }

    private void initBlockPanels() {
        blockPanels = new JPanel[TetrisBoard.MAX_ROW + 1][TetrisBoard.MAX_COL + 1];

        for (int row = 0; row <= TetrisBoard.MAX_ROW; row++) {
            for (int col = 0; col <= TetrisBoard.MAX_COL; col++) {
                JPanel blockPanel = new JPanel();
                blockPanel.setBackground(DEFAULT_BLOCK_COLOR);
                blockPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, BLOCK_BORDER_THICKNESS));
                blockPanels[row][col] = blockPanel;
                this.add(blockPanel);
            }
        }
    }

    public void colorPointsOnBlockPanels(Point[] points, Color color) {
        for (Point point : points) {
            blockPanels[point.getRow()][point.getCol()].setBackground(color);
        }
    }

    public void erasePointsFromBlockPanels(Point[] points) {
        colorPointsOnBlockPanels(points, DEFAULT_BLOCK_COLOR);
    }

    public void colorLinesOnBlockPanels() {
        for (int row = 0; row <= TetrisBoard.MAX_ROW; row++) {
            for (int col = 0; col <= TetrisBoard.MAX_COL; col++)
            {
                if (tetrisBoard.checkPointFilled(row ,col))
                    blockPanels[row][col].setBackground(DEFAULT_LINE_COLOR);
                else
                    blockPanels[row][col].setBackground(DEFAULT_BLOCK_COLOR);
            }
        }
    }

    public void colorBlockPanelsForGameOver() {
        for (JPanel[] blockPanelRow : blockPanels)
            for (JPanel blockPanel : blockPanelRow)
                blockPanel.setBackground(DEFAULT_LINE_COLOR);
    }
}
