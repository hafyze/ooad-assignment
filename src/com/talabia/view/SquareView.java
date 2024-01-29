package com.talabia.view;

import javax.swing.*;

// Programmers : Sumedha Endar
// This is the SquareView of our Talabia Chess Game.
// The purpose of this SquareView is we find that having it we can easily
// know the row and col of the button we clicked.

public class SquareView extends JButton {

    private int row;
    private int col;

    // Programmers: Sumedha Endar
    // This is the SquareView Constructor
    public SquareView(int row, int col){
        this.row = row;
        this.col = col;
    }

    // Programmers: Sumedha Endar
    // These are the Setters & Getters
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
    // End of Setters & Getters
}
