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

        // Move forward (upward)
        boolean canMove = true;
        for (int i = 1; i <= boardRow && canMove; i++) {
            int newRow = currentRow - i;
            if (newRow >= 0) {
                possibleMoves.add(squares[newRow][currentCol]);
                canMove = !squares[newRow][currentCol].isOccupied();
            }
        }

        // Move backward (downward)
        canMove = true;
        for (int i = 1; i <= boardRow && canMove; i++) {
            int newRow = currentRow + i;
            if (newRow < boardRow) {
                possibleMoves.add(squares[newRow][currentCol]);
                canMove = !squares[newRow][currentCol].isOccupied();
            }
        }

        // Move horizontally
        canMove = true;
        for (int i = 1; i <= boardCol && canMove; i++) {
            int newCol = currentCol - i;
            if (newCol >= 0) {
                possibleMoves.add(squares[currentRow][newCol]);
                canMove = !squares[currentRow][newCol].isOccupied();
            }
        }

        canMove = true;
        for (int i = 1; i <= boardCol && canMove; i++) {
            int newCol = currentCol + i;
            if (newCol < boardCol) {
                possibleMoves.add(squares[currentRow][newCol]);
                canMove = !squares[currentRow][newCol].isOccupied();
            }
        }
        this.possibleMoves = possibleMoves;
    }

    @Override
    public ArrayList<Square> getPossibleMoves() {
        return this.possibleMoves;
    }
}
