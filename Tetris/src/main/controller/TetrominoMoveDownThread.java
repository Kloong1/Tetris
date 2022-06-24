package main.controller;

public class TetrominoMoveDownThread extends Thread {

    private final TetrisController tetrisController;

    private int moveDelay = 1000;

    private static final int MIN_MOVE_DELAY = 200;
    private static final int DELAY_DECREASE = 10;

    public TetrominoMoveDownThread(TetrisController tetrisController) {
        this.tetrisController = tetrisController;
        setDaemon(true);
    }
    @Override
    public void run() {
        while (true) {
            try {
                sleep(moveDelay);
                if (!tetrisController.isGameOver()) {
                    tetrisController.moveTetrominoDown();
                }
            } catch (InterruptedException ignored) { }
        }
    }

    public void speedUp() {
        if (moveDelay > MIN_MOVE_DELAY)
            moveDelay -= DELAY_DECREASE;
    }
}
