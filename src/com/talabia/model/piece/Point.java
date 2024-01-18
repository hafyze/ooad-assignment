package com.talabia.model.piece;

public class Point extends AbstractPiece {

    public Point(PieceColor pieceColor) {
        super(pieceColor);
        this.pieceName = "Point";
        this.pieceImageName = pieceColor.toString() + "_" + pieceName;
    }


}
