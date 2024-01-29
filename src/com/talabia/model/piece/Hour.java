package com.talabia.model.piece;

import com.talabia.model.board.Square;

import java.util.ArrayList;

// Programmers : Afiq
// This is the Hour Piece Model in our Talabia Chess Game.
// It extends the AbstractPiece superclass. The main purpose of this class is to set the
// unique movement for the Hour Pieces.
public class Hour extends AbstractPiece {

    // Programmers: Afiq
    // This is the Hour Piece Constructor
    public Hour(PieceColor pieceColor) {
        super("Hour", pieceColor);
        this.pieceImageName = pieceColor.toString() + "_" + pieceName;
    }

    // Programmers: Afiq
    // To calculate and set the possible moves of the Hour
    @Override
    public void setPossibleMoves(Square currentSquare, Square[][] squares) {
        ArrayList<Square> possibleMoves = new ArrayList<>();

        int currentRow = currentSquare.getRow();
        int currentCol = currentSquare.getColumn();

        // Define the possible move offsets for the Hourglass piece
        int[][] moveOffsets = {
                {-2, -1}, {-2, 1},
                {-1, -2}, {-1, 2},
                {1, -2}, {1, 2},
                {2, -1}, {2, 1}
        };

        // Check each possible move
        for (int[] offset : moveOffsets) {
            int newRow = currentRow + offset[0];
            int newCol = currentCol + offset[1];

            // Check if the new position is within the board bounds
            if (newRow >= 0 && newRow < squares.length && newCol >= 0 && newCol < squares[0].length) {
                // Check if the square is not occupied or occupied by an opponent's piece
                if (!squares[newRow][newCol].isOccupied() || squares[newRow][newCol].getPiece().getPieceColor() != this.pieceColor) {
                    possibleMoves.add(squares[newRow][newCol]);
                }
            }
        }

        this.possibleMoves = possibleMoves;
    }



    @Override
    public ArrayList<Square> getPossibleMoves() {return possibleMoves;}
}
