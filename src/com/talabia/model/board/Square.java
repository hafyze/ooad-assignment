package com.talabia.model.board;

import com.talabia.model.piece.*;

public class Square {
    private int row;
    private int column;

    private boolean isOccupied;
    private AbstractPiece piece;

    public Square() {
        this.row = 0;
        this.column = 0;
        this.isOccupied = false;
        this.piece = null;
    }

    public Square(int row, int column){
        this.row = row;
        this.column = column;
        this.isOccupied = false;
        this.piece = null;
    }

    public void placeNewPiece(String pieceName, PieceColor color) {
        this.piece = createPiece(pieceName, color);
        this.isOccupied = true;
    }

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

    public PieceColor getPieceColor() {
        if (isOccupied && piece != null) {
            return piece.getPieceColor();
        } else {
            return null;
        }
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
