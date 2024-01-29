package com.talabia.model.piece;

import com.talabia.model.board.Square;

import java.util.ArrayList;

public class Point extends AbstractPiece {

    /**
     * Constructor for the Point piece.
     *
     * @param pieceColor The color of the Point piece (LIGHT or DARK).
     */
    public Point(PieceColor pieceColor) {
        super("Point", pieceColor);
        this.pieceImageName = pieceColor.toString() + "_" + pieceName;
    }

    /**
     * Sets the possible moves for the Point piece on the given chessboard.
     *
     * @param currentSquare The current position of the Point piece.
     * @param squares       The 2D array representing the chessboard.
     */
    @Override
    public void setPossibleMoves(Square currentSquare, Square[][] squares) {
        ArrayList<Square> possibleMoves = new ArrayList<>();

        int currentRow = currentSquare.getRow();
        int currentCol = currentSquare.getColumn();
        int forwardDirection = (pieceColor == PieceColor.LIGHT) ? -1 : 1;  // Adjust the direction based on piece color

        // Move forward 1 step
        int newRow = currentRow + forwardDirection;
        if (isValidMove(currentRow, currentCol, newRow, currentCol, squares)) {
            possibleMoves.add(squares[newRow][currentCol]);
        }

        // Move forward 2 steps if at the starting row
        if (currentRow == getStartingRow()) {
            newRow = currentRow + 2 * forwardDirection;
            if (isValidMove(currentRow, currentCol, newRow, currentCol, squares)) {
                possibleMoves.add(squares[newRow][currentCol]);
            }
        }

        this.possibleMoves = possibleMoves;
    }

    /**
     * Gets the possible moves for the Point piece.
     *
     * @return ArrayList of possible moves.
     */
    @Override
    public ArrayList<Square> getPossibleMoves() {
        return this.possibleMoves;
    }

    /**
     * Checks if a move for the Point piece is valid.
     *
     * @param fromRow  The starting row of the move.
     * @param fromCol  The starting column of the move.
     * @param toRow    The destination row of the move.
     * @param toCol    The destination column of the move.
     * @param squares  The 2D array representing the chessboard.
     * @return True if the move is valid, false otherwise.
     */
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, Square[][] squares) {
        // Check if the move is within the allowed range and in a forward direction
        int rowDifference = Math.abs(toRow - fromRow);
        int colDifference = Math.abs(toCol - fromCol);
        int forwardDirection = (pieceColor == PieceColor.LIGHT) ? -1 : 1;  // Adjust the direction based on piece color

        return rowDifference <= 2 && colDifference == 0 && (toRow - fromRow) * forwardDirection > 0;
    }

    /**
     * Gets the starting row for the Point piece based on its color.
     *
     * @return The starting row.
     */
    private int getStartingRow() {
        return (pieceColor == PieceColor.LIGHT) ? 6 : 1;  // Adjust based on piece color
    }
}
