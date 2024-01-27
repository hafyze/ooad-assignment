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

    @Override
    public ArrayList<Square> getPossibleMoves() {
        return this.possibleMoves;
    }

    // Ensure this method overrides the method in the superclass
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, Square[][] squares) {
        // Check if the move is within the allowed range and in a forward direction
        int rowDifference = Math.abs(toRow - fromRow);
        int colDifference = Math.abs(toCol - fromCol);
        int forwardDirection = (pieceColor == PieceColor.LIGHT) ? -1 : 1;  // Adjust the direction based on piece color

        return rowDifference <= 2 && colDifference == 0 && (toRow - fromRow) * forwardDirection > 0;
    }

    // Assuming there is a getStartingRow method in your AbstractPiece class
    private int getStartingRow() {
        return (pieceColor == PieceColor.LIGHT) ? 6 : 1;  // Adjust based on piece color
    }
}

