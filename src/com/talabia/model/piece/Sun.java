package com.talabia.model.piece;

public class Sun extends AbstractPiece{
    public Sun(PieceColor pieceColor) {
        super(pieceColor);
        this.pieceName = "Sun";
        this.pieceImageName = pieceColor.toString() + "_" + pieceName;
    }
}
