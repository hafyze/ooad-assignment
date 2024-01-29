package com.talabia.model.piece;

import com.talabia.model.board.Board;
import com.talabia.model.board.Square;

import java.util.ArrayList;

// Programmers : Zulhafiz
// This is the Plus Piece Model in our Talabia Chess Game.
// It extends the AbstractPiece superclass. The main purpose of this class is to set the
// unique movement for the Plus Pieces.

public class Plus extends AbstractPiece{

    // Programmers: Zulhafiz
    // This is the Plus Piece Constructor
    public Plus(PieceColor pieceColor) {
        super("Plus", pieceColor);
        this.pieceImageName = pieceColor.toString() + "_" + pieceName;
    }

    // Programmers: Zulhafiz
    // To calculate and set the possible moves of the Sun
    @Override
    public void setPossibleMoves(Square currentSquare, Square[][] squares) {
        ArrayList<Square> possibleMoves = new ArrayList<>();
        Board board = new Board();

        int boardRow = board.getBoardRow();
        int boardCol = board.getBoardCol();

        int currentRow = currentSquare.getRow();
        int currentCol = currentSquare.getColumn();

        // Move up
        calculateMoves(possibleMoves, squares, currentRow, currentCol, -1, 0, boardRow);

        // Move down
        calculateMoves(possibleMoves, squares, currentRow, currentCol, 1, 0, boardRow);

        // Move left
        calculateMoves(possibleMoves, squares, currentRow, currentCol, 0, -1, boardCol);

        // Move right
        calculateMoves(possibleMoves, squares, currentRow, currentCol, 0, 1, boardCol);

        this.possibleMoves = possibleMoves;
    }

    //Method to calculate moves depending on the row direction
    private void calculateMoves(ArrayList<Square> possibleMoves, Square[][] squares,
                                int currentRow, int currentCol, int rowDirection,
                                int colDirection, int maxSteps) {
        boolean canMove = true;
        for (int i = 1; i <= maxSteps && canMove; i++) {
            int newRow = currentRow + i * rowDirection;
            int newCol = currentCol + i * colDirection;

            if (newRow >= 0 && newRow < squares.length && newCol >= 0 && newCol < squares[0].length) {
                Square targetSquare = squares[newRow][newCol];

                // Check if square is occupied by the same color
                if (!targetSquare.isOccupied() || targetSquare.getPiece().getPieceColor() != getPieceColor()) {
                    possibleMoves.add(targetSquare);
                    canMove = !targetSquare.isOccupied();
                } else {
                    // Break loop if target square is occupied by the same color
                    break;
                }
            }
        }
    }

    @Override
    public ArrayList<Square> getPossibleMoves() {
        return this.possibleMoves;
    }
    //End of methods
}
//End of Class