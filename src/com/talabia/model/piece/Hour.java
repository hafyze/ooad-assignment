package com.talabia.model.piece;

import com.talabia.model.board.Square;

import java.util.ArrayList;

public class Hour extends AbstractPiece {

    public Hour(PieceColor pieceColor) {
        super("Hour", pieceColor);
        this.pieceImageName = pieceColor.toString() + "_" + pieceName;
    }

    @Override
    public ArrayList<Square> getPossibleMoves(Square currentSquare, Square[][] squares) {
        return null;
    }
}
