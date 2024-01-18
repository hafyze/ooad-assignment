package com.talabia.model.piece;

public class Time extends AbstractPiece{
    public Time(PieceColor pieceColor) {
        super(pieceColor);
        this.pieceName = "Time";
        this.pieceImageName = pieceColor.toString() + "_" + pieceName;
    }
}
