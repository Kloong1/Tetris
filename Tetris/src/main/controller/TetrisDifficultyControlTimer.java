package main.controller;

import java.util.Timer;
import java.util.TimerTask;

public class TetrisDifficultyControlTimer extends Timer {

    private final TimerTask difficultyControlTimerTask;

    private final static int PERIOD = 10000;

    public TetrisDifficultyControlTimer(TetrominoMoveDownThread tetrominoMoveDownThread) {
        super(true);
        this.difficultyControlTimerTask = new TimerTask() {
            @Override
            public void run() {
                tetrominoMoveDownThread.speedUp();
            }
        };
    }

    public void start() {
        this.schedule(difficultyControlTimerTask, 0, PERIOD);
    }
}
