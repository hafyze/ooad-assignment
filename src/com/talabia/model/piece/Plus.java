package com.talabia.model.piece;

public class Plus extends AbstractPiece{

    public Plus(PieceColor pieceColor) {
        super(pieceColor);
        this.pieceName = "Plus";
        this.pieceImageName = pieceColor.toString() + "_" + pieceName;
    }
}
