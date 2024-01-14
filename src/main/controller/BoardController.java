package main.controller;

import main.model.BoardModel;
import main.view.BoardView;

import java.awt.Color;

public class BoardController {

    private final BoardModel model;

    public BoardController() {
        this.model = new BoardModel();
        BoardView view = new BoardView(this);
    }

    public Color getCellColor(int row, int col) {
        return model.getCellColor(row, col);
    }

    public static void main(String[] args) {
        new BoardController();
    }
}
