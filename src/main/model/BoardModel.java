package main.model;

import java.awt.Color;

public class BoardModel {

    private static final int BOARD_SIZE = 8;
    private Color[][] board;

    public BoardModel() {
        initializeBoard();
    }

    private void initializeBoard() {
        board = new Color[BOARD_SIZE][BOARD_SIZE];

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if ((row + col) % 2 == 0) {
                    board[row][col] = Color.WHITE;
                } else {
                    board[row][col] = Color.BLACK;
                }
            }
        }
    }

    public Color getCellColor(int row, int col) {
        return board[row][col];
    }
}
