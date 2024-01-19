package com.talabia.model.piece;

import com.talabia.model.board.Square;

import java.util.ArrayList;

public abstract class AbstractPiece {
    protected String pieceName;
    protected PieceColor pieceColor;
    protected String pieceImageName;

    public AbstractPiece(String pieceName, PieceColor pieceColor){
        this.pieceColor = pieceColor;
        this.pieceName = pieceName;
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

    public abstract ArrayList<Square> getPossibleMoves(Square currentSquare, Square[][] squares);

    @Override
    public String toString() {
        return "AbstractPiece{" +
                "pieceName='" + pieceName + '\'' +
                ", pieceColor=" + pieceColor +
                '}';
    }
}
