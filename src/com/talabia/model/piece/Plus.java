package com.talabia.model.piece;

import com.talabia.model.board.Board;
import com.talabia.model.board.Square;

import java.util.ArrayList;

public class Plus extends AbstractPiece{

    public Plus(PieceColor pieceColor) {
        super("Plus", pieceColor);
        this.pieceImageName = pieceColor.toString() + "_" + pieceName;
    }

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

    private void calculateMoves(ArrayList<Square> possibleMoves, Square[][] squares,
                                int currentRow, int currentCol, int rowDirection,
                                int colDirection, int maxSteps) {
        boolean canMove = true;
        for (int i = 1; i <= maxSteps && canMove; i++) {
            int newRow = currentRow + i * rowDirection;
            int newCol = currentCol + i * colDirection;

            if (newRow >= 0 && newRow < squares.length && newCol >= 0 && newCol < squares[0].length) {
                possibleMoves.add(squares[newRow][newCol]);
                canMove = !squares[newRow][newCol].isOccupied();
            } else {
                break;
            }
        }
    }
    @Override
    public ArrayList<Square> getPossibleMoves() {
        return this.possibleMoves;
    }
}
