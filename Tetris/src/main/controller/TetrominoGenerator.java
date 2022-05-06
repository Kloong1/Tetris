package controller;

import board.TetrisBoard;
import tetromino.*;

import java.util.ArrayList;
import java.util.Collections;

public class TetrominoGenerator {

    private final ArrayList<Tetromino> tetrominos = new ArrayList<>(7);
    private int idx = 0;
    private final TetrisBoard tetrisBoard;

    public TetrominoGenerator(TetrisBoard tetrisBoard) {
        this.tetrisBoard = tetrisBoard;
        initTetrominos();
    }

    public Tetromino getTetromino() {
        if (idx >= tetrominos.size()) {
            idx = 0;
            initTetrominos();
        }
        return tetrominos.get(idx++);
    }

    public Tetromino peekNextTetromino() {
        if (idx >= tetrominos.size())
            return tetrominos.get(0);
        return tetrominos.get(idx);
    }

    private void initTetrominos() {
        tetrominos.clear();
        tetrominos.add(new TetrominoI(tetrisBoard));
        tetrominos.add(new TetrominoJ(tetrisBoard));
        tetrominos.add(new TetrominoL(tetrisBoard));
        tetrominos.add(new TetrominoO(tetrisBoard));
        tetrominos.add(new TetrominoS(tetrisBoard));
        tetrominos.add(new TetrominoT(tetrisBoard));
        tetrominos.add(new TetrominoZ(tetrisBoard));
        Collections.shuffle(tetrominos);
    }
}
