package controller;

public class TetrominoMoverThread extends Thread {
    private final TetrisController tetrisController;

    private int delayDecrease = 10;
    private int moveDelay = 1000;

    public TetrominoMoverThread(TetrisController tetrisController) {
        this.tetrisController = tetrisController;
        setDaemon(true);
    }

    private void setDelayDecrease() {
        delayDecrease = moveDelay / 100;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(moveDelay);
                if (!tetrisController.isGameOver()) {
                    tetrisController.moveTetrominoDown();
                    setDelayDecrease();
                    if (moveDelay > 200)
                        moveDelay -= delayDecrease;
                }
            } catch (InterruptedException ignored) { }
        }
    }
}
