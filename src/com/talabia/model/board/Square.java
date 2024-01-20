package com.talabia.model.board;

import com.talabia.model.piece.AbstractPiece;

public class Square {
    private int row;
    private int column;

    private boolean isOccupied;
    private AbstractPiece piece;

    public Square(int row, int column){
        this.row = row;
        this.column = column;
        this.isOccupied = false;
        this.piece = null;
    }

    public Square(int row, int column, AbstractPiece piece){
        this.row = row;
        this.column = column;
        this.isOccupied = true;
        this.piece = piece;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public AbstractPiece getPiece() {
        return piece;
    }

    public void setPiece(AbstractPiece piece, boolean isOccupied) {
        this.piece = piece;
        this.isOccupied = isOccupied;
    }

    @Override
    public String toString() {
        return "Square{" +
                "row=" + row +
                ", column=" + column +
                ", isOccupied=" + isOccupied +
                ", piece=" + piece +
                '}';
    }
}