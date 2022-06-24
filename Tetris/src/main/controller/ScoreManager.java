package main.controller;

public class ScoreManager {
    private int score = 0;
    private int combo = -1;

    public int getScore() {
        return score;
    }

    public int getCombo() {
        return combo + 1;
    }

    public void updateScoreAndCombo(int clearedLines) {
        if (clearedLines == 0) {
            combo = -1;
            return;
        }
        combo++;
        score += calculateScore(clearedLines);
    }

    private int calculateScore(int clearedLines) {
        int calculatedScore;
        switch (clearedLines) {
            case 1: calculatedScore = 100 + combo * 100; break;
            case 2: calculatedScore = 300 + combo * 100; break;
            case 3: calculatedScore = 600 + combo * 100; break;
            case 4: calculatedScore = 1000 + combo * 100; break;
            default: calculatedScore = 0;
        }
        return calculatedScore;
    }
}
