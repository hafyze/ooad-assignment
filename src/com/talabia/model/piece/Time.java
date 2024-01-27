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

        // Make diagonal movements
        calculateDiagonalMoves(currentRow, currentCol, squares, possibleMoves);

        this.possibleMoves = possibleMoves;
    }

    @Override
    public ArrayList<Square> getPossibleMoves() {
        return this.possibleMoves;
    }

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
}

