package com.talabia.model.piece;

import com.talabia.model.board.Square;

import java.util.ArrayList;

public class Plus extends AbstractPiece{

    public Plus(PieceColor pieceColor) {
        super("Plus", pieceColor);
        this.pieceImageName = pieceColor.toString() + "_" + pieceName;
    }

    @Override
    public void setPossibleMoves(Square currentSquare, Square[][] squares) {

    }

    @Override
    public ArrayList<Square> getPossibleMoves() {
        return null;
    }
}
