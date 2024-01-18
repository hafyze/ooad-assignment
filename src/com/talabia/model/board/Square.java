package com.talabia.model.board;

import com.talabia.model.piece.AbstractPiece;

public class Square {
    private final Location location;
    private boolean isOccupied;
    private AbstractPiece piece;

    public Square(Location location){
        this.location = location;
        this.isOccupied = false;
    }

    public Location getLocation() {
        return location;
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

    public void setPiece(AbstractPiece piece) {
        this.piece = piece;
        this.isOccupied = true;
    }

    @Override
    public String toString() {
        return "Square{" +
                "location=" + location +
                ", isOccupied=" + isOccupied +
                ", piece=" + piece +
                '}';
    }
}
