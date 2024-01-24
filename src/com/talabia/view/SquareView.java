package com.talabia.view;

import javax.swing.*;

public class SquareView extends JButton {

    private int row;
    private int col;

    public SquareView(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
