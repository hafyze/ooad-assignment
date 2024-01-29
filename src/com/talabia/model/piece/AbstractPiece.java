package com.talabia.model.piece;

import com.talabia.model.board.Square;
import java.util.ArrayList;

// Programmers : Sumedha Endar
// This is the AbstractPiece Model in our Talabia Chess Game.
// The AbstractPiece Model contains all the necessary calculations and logics related to all pieces.
// However, the unique movements of each piece will then be overridden in their on class.

public abstract class AbstractPiece {
    protected String pieceName;
    protected PieceColor pieceColor;
    protected String pieceImageName;
    protected ArrayList<Square> possibleMoves;

    // Programmers: Sumedha Endar
    // This is the AbstractPiece Constructor
    public AbstractPiece(String pieceName, PieceColor pieceColor){
        this.pieceColor = pieceColor;
        this.pieceName = pieceName;
    }

    // Programmers: Sumedha Endar
    // These are the Setters & Getters
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

    // Abstract methods to be overridden in the subclasses
    public abstract void setPossibleMoves(Square currentSquare, Square[][] squares);

    public abstract ArrayList<Square> getPossibleMoves();
    // End of Abstract Methods
    // End of Setters & Getters
}
