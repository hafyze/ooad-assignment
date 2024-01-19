package com.talabia.model.piece;

import com.talabia.model.board.Square;

import java.util.ArrayList;

public class Time extends AbstractPiece{
    public Time(PieceColor pieceColor) {
        super("Time", pieceColor);
        this.pieceImageName = pieceColor.toString() + "_" + pieceName;
    }

    @Override
    public ArrayList<Square> getPossibleMoves(Square currentSquare, Square[][] squares) {
        return null;
    }
}
