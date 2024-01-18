package com.talabia.model.piece;

import java.util.List;

public abstract class AbstractPiece {
    protected String pieceName;
    protected PieceColor pieceColor;
    protected String pieceImageName;

    public AbstractPiece(PieceColor pieceColor){
        this.pieceColor = pieceColor;
        this.pieceName = "";
    }

    public String getPieceName() {
        return pieceName;
    }

    public void setPieceName(String pieceName) {
        this.pieceName = pieceName;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public String getPieceImageName() {
        return pieceImageName;
    }

    @Override
    public String toString() {
        return "AbstractPiece{" +
                "pieceName='" + pieceName + '\'' +
                ", pieceColor=" + pieceColor +
                '}';
    }
}
