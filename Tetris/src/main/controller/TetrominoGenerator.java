package controller;

import board.Board;
import tetromino.*;

import java.util.ArrayList;
import java.util.Collections;

public class TetrominoGenerator {

    private final ArrayList<Tetromino> tetrominos = new ArrayList<>(7);
    private int idx = 0;
    private final Board board;

    public TetrominoGenerator(Board board) {
        this.board = board;
        initTetrominos();
    }

    public Tetromino getNextTetromino() {
        if (idx >= tetrominos.size()) {
            idx = 0;
            initTetrominos();
        }
        return tetrominos.get(idx++);
    }

    private void initTetrominos() {
        tetrominos.add(new TetrominoI(board));
        tetrominos.add(new TetrominoJ(board));
        tetrominos.add(new TetrominoL(board));
        tetrominos.add(new TetrominoO(board));
        tetrominos.add(new TetrominoS(board));
        tetrominos.add(new TetrominoT(board));
        tetrominos.add(new TetrominoZ(board));
        Collections.shuffle(tetrominos);
    }
}
