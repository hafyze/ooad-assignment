package com.talabia.model.piece;

import com.talabia.model.board.Square;

import java.util.ArrayList;

public class Hour extends AbstractPiece {

    /**
     * Constructor for the Hourglass piece.
     *
     * @param pieceColor The color of the Hourglass piece (LIGHT or DARK).
     */
    public Hour(PieceColor pieceColor) {
        super("Hour", pieceColor);
        this.pieceImageName = pieceColor.toString() + "_" + pieceName;
    }

    /**
     * Sets the possible moves for the Hourglass piece on the given chessboard.
     *
     * @param currentSquare The current position of the Hourglass piece.
     * @param squares       The 2D array representing the chessboard.
     */
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

    /**
     * Gets the possible moves for the Hourglass piece.
     *
     * @return ArrayList of possible moves.
     */
    @Override
    public ArrayList<Square> getPossibleMoves() {
        return possibleMoves;
    }
}

