package main.controller;

import main.board.TetrisBoard;
import main.tetromino.*;

import java.util.ArrayList;
import java.util.Collections;

public class TetrominoGenerator {

    private final TetrisBoard tetrisBoard;

    private ArrayList<Tetromino> currentRoundTetrominos = new ArrayList<>(7);
    private ArrayList<Tetromino> nextRoundTetrominos = new ArrayList<>(7);
    private int idx = 0;

    public TetrominoGenerator(TetrisBoard tetrisBoard) {
        this.tetrisBoard = tetrisBoard;
        initNextRoundTetrominos();
        swapTetrominosArrayList();
        initNextRoundTetrominos();
    }

    public Tetromino getTetromino() {
        if (idx >= currentRoundTetrominos.size()) {
            idx = 0;
            swapTetrominosArrayList();
            initNextRoundTetrominos();
        }
        return currentRoundTetrominos.get(idx++);
    }

    public Tetromino peekNextTetromino() {
        if (idx >= currentRoundTetrominos.size()) {
            return nextRoundTetrominos.get(0);
        }
        return currentRoundTetrominos.get(idx);
    }

    private void initNextRoundTetrominos() {
        nextRoundTetrominos.clear();
        nextRoundTetrominos.add(new TetrominoI(tetrisBoard));
        nextRoundTetrominos.add(new TetrominoJ(tetrisBoard));
        nextRoundTetrominos.add(new TetrominoL(tetrisBoard));
        nextRoundTetrominos.add(new TetrominoO(tetrisBoard));
        nextRoundTetrominos.add(new TetrominoS(tetrisBoard));
        nextRoundTetrominos.add(new TetrominoT(tetrisBoard));
        nextRoundTetrominos.add(new TetrominoZ(tetrisBoard));
        Collections.shuffle(nextRoundTetrominos);
    }

    private void swapTetrominosArrayList() {
        ArrayList<Tetromino> temp;
        temp = currentRoundTetrominos;
        currentRoundTetrominos = nextRoundTetrominos;
        nextRoundTetrominos = temp;
    }
}
