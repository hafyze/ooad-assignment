package com.talabia.model.piece;

import com.talabia.model.board.Square;

import java.util.ArrayList;

// Programmers : Zulhafiz
// This is the Time Piece Model in our Talabia Chess Game.
// It extends the AbstractPiece superclass. The main purpose of this class is to set the
// unique movement for the Time Pieces.

public class Time extends AbstractPiece {

    // Programmers: Zulhafiz
    // This is the Time Piece Constructor
    public Time(PieceColor pieceColor) {
        super("Time", pieceColor);
        this.pieceImageName = pieceColor.toString() + "_" + pieceName;
    }

    // Programmers: Zulhafiz
    // To calculate and set the possible moves of the Time
    @Override
    public void setPossibleMoves(Square currentSquare, Square[][] squares) {
        ArrayList<Square> possibleMoves = new ArrayList<>();

        int currentRow = currentSquare.getRow();
        int currentCol = currentSquare.getColumn();

        // Make diagonal movements
        calculateDiagonalMoves(currentRow, currentCol, squares, possibleMoves);

        this.possibleMoves = possibleMoves;
    }

    //Getters
    @Override
    public ArrayList<Square> getPossibleMoves() {
        return this.possibleMoves;
    }

    //Method that will check the diagonal move and add into possible moves
    private void calculateDiagonalMoves(int currentRow, int currentCol, Square[][] squares, ArrayList<Square> possibleMoves) {
        for (int rowDirection : new int[]{-1, 1}) {
            for (int colDirection : new int[]{-1, 1}) {
                int row = currentRow + rowDirection;
                int col = currentCol + colDirection;

                while (isValidMove(row, col, squares)) {
                    Square square = squares[row][col];

                    if (!square.isOccupied()) {
                        possibleMoves.add(square);
                    } else {
                        // Break only if the occupied piece is different color
                        if (square.getPiece().getPieceColor() != this.pieceColor) {
                            possibleMoves.add(square);
                        }
                        break;
                    }

                    row += rowDirection;
                    col += colDirection;
                }
            }
        }
    }

    private boolean isValidMove(int row, int col, Square[][] squares) {
        return row >= 0 && row < squares.length && col >= 0 && col < squares[0].length;
    }
    //End of methods
}
//End of class
