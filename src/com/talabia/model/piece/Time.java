package com.talabia.model.piece;

import com.talabia.model.board.Square;

import java.util.ArrayList;

public class Time extends AbstractPiece {

    public Time(PieceColor pieceColor) {
        super("Time", pieceColor);
        this.pieceImageName = pieceColor.toString() + "_" + pieceName;
    }

    @Override
    public void setPossibleMoves(Square currentSquare, Square[][] squares) {
        ArrayList<Square> possibleMoves = new ArrayList<>();

        int currentRow = currentSquare.getRow();
        int currentCol = currentSquare.getColumn();

        // Check diagonal movements
        for (int rowDirection : new int[]{-1, 1}) {
            for (int colDirection : new int[]{-1, 1}) {
                int row = currentRow + rowDirection;
                int col = currentCol + colDirection;

                while (row >= 0 && row < squares.length && col >= 0 && col < squares[0].length) {
                    Square square = squares[row][col];
                    possibleMoves.add(square);

                    // Move to the next square diagonally
                    row += rowDirection;
                    col += colDirection;
                }
            }
        }

        this.possibleMoves = possibleMoves;
    }

    @Override
    public ArrayList<Square> getPossibleMoves() {
        return this.possibleMoves;
    }
}

