package score;

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
        return switch (clearedLines) {
            case 1 -> 100 + combo * 100;
            case 2 -> 300 + combo * 100;
            case 3 -> 600 + combo * 100;
            case 4 -> 1000 + combo * 100;
            default -> 0;
        };
    }
}
