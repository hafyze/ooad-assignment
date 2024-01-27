package com.talabia.model.piece;

import com.talabia.model.board.Square;

import java.util.ArrayList;

public class Point extends AbstractPiece {

    public Point(PieceColor pieceColor) {
        super("Point", pieceColor);
        this.pieceImageName = pieceColor.toString() + "_" + pieceName;
    }

    @Override
    public void setPossibleMoves(Square currentSquare, Square[][] squares) {
        ArrayList<Square> possibleMoves = new ArrayList<>();

        int currentRow = currentSquare.getRow();
        int currentCol = currentSquare.getColumn();

        // Forward movement
        for (int i = 1; i <= 2; i++) {
            int newRow = currentRow - i;
            if (newRow >= 0) {
                possibleMoves.add(squares[newRow][currentCol]);
            }
        }

        // Backward movement
        for (int i = 1; i <= 2; i++) {
            int newRow = currentRow + i;
            if (newRow < squares.length) {
                possibleMoves.add(squares[newRow][currentCol]);
            }
        }

        this.possibleMoves = possibleMoves;
    }

    public ArrayList<Square> getPossibleMoves(){
        return this.possibleMoves;
    }

}
