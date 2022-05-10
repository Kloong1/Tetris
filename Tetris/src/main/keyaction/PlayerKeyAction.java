package keyaction;

import controller.TetrisController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PlayerKeyAction extends AbstractAction {

    public static final String MOVE_DOWN = "md";
    public static final String MOVE_LEFT = "ml";
    public static final String MOVE_RIGHT = "mr";
    public static final String DROP = "dr";

    public static final String ROTATE_CLOCKWISE = "rc";
    public static final String ROTATE_ANTICLOCKWISE = "rac";

    private final TetrisController tetrisController;

    private final String key;

    public PlayerKeyAction(String key, TetrisController tetrisController) {
        this.key = key;
        this.tetrisController = tetrisController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tetrisController.isGameOver())
            return;

        switch (key) {
            case MOVE_LEFT -> moveTetrominoLeft();
            case MOVE_RIGHT -> moveTetrominoRight();
            case MOVE_DOWN -> moveTetrominoDown();
            case DROP -> dropTetromino();
            case ROTATE_CLOCKWISE -> rotateClockwiseTetromino();
            case ROTATE_ANTICLOCKWISE -> rotateAnticlockwiseTetromino();
        }
    }


    private void moveTetrominoRight() {
        tetrisController.moveTetrominoRight();
    }

    private void moveTetrominoLeft() {
        tetrisController.moveTetrominoLeft();
    }

    private void moveTetrominoDown() {
        tetrisController.moveTetrominoDown();
    }

    private void dropTetromino() {
        tetrisController.dropTetromino();
    }

    private void rotateClockwiseTetromino() {
        tetrisController.rotateClockwiseTetromino();
    }

    private void rotateAnticlockwiseTetromino() {
        tetrisController.rotateAnticlockwiseTetromino();
    }
}
