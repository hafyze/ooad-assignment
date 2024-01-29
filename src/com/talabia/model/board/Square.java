package com.talabia.model.board;

import com.talabia.model.piece.*;

// Programmers : Sumedha Endar, Iyad Najimi
// This is the Square Model in our Talabia Chess Game.
// The Square Model performs all the calculations and logics related to a Square in the Board.

public class Square {
    private int row;
    private int column;
    private boolean isOccupied;
    private AbstractPiece piece;

    // Programmers: Sumedha Endar
    // These are the Square Constructors
    // For Square that doesn't have a piece on it
    public Square(int row, int column){
        this.row = row;
        this.column = column;
        this.isOccupied = false;
        this.piece = null;
    }
    // For Square that does have a piece on it
    public Square(int row, int column, AbstractPiece piece){
        this.row = row;
        this.column = column;
        this.isOccupied = true;
        this.piece = piece;
    }
    // End of Constructors

    // Programmers: Sumedha Endar, Iyad Najimi
    // These are the Setters & Getters
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

    public PieceColor getPieceColor() {
        if (isOccupied && piece != null) {
            return piece.getPieceColor();
        } else {
            return null;
        }
    }
    // End of Setters & Getters

    // Programmers: Iyad Najimi
    // This method used when load the BoardState.txt file.
    // Its purpose is to place a new piece in a square
    public void placeNewPiece(String pieceName, PieceColor color) {
        this.piece = createPiece(pieceName, color);
        this.isOccupied = true;
    }

    // Programmers: Iyad Najimi
    // This method used when load the BoardState.txt file.
    // Its purpose is to determine which piece type to be created.
    private AbstractPiece createPiece(String pieceName, PieceColor color) {
        switch (pieceName) {
            case "Hour":
                return new Hour(color);
            case "Plus":
                return new Plus(color);
            case "Point":
                return new Point(color);
            case "Sun":
                return new Sun(color);
            case "Time":
                return new Time(color);
            default:
                throw new IllegalArgumentException("Invalid piece name: " + pieceName);
        }
    }
}
