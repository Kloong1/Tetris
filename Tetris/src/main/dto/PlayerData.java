package main.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class PlayerData implements Serializable {

    private final boolean[][] board;
    private final int score;
    private final int combo;

    //private final int garbageLines;

    public PlayerData(boolean[][] board, int score, int combo) {
        this.board = board;
        this.score = score;
        this.combo = combo;
    }
}
