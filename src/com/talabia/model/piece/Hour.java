package com.talabia.model.piece;

public class Hour extends AbstractPiece {

    public Hour(PieceColor pieceColor) {
        super(pieceColor);
        this.pieceName = "Hour";
        this.pieceImageName = pieceColor.toString() + "_" + pieceName;
    }
}
