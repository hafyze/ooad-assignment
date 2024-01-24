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
        for (int i = 1; i <= boardRow; i++) {
            int newRow = currentRow - i;
            if (newRow >= 0) {
                possibleMoves.add(squares[newRow][currentCol]);
            }
        }

        // Move backward (downward)
        for (int i = 1; i <= boardRow; i++) {
            int newRow = currentRow + i;
            if (newRow < squares.length) {
                possibleMoves.add(squares[newRow][currentCol]);
            }
        }

        // Move horizontally
        for (int i = 1; i <= boardCol; i++) {
            int newCol = currentCol - i;
            if (newCol >= 0) {
                possibleMoves.add(squares[currentRow][newCol]);
            }
        }

        for (int i = 1; i <= boardCol; i++) {
            int newCol = currentCol + i;
            if (newCol < squares[0].length) {
                possibleMoves.add(squares[currentRow][newCol]);
            }
        }
        this.possibleMoves = possibleMoves;
    }

    @Override
    public ArrayList<Square> getPossibleMoves() {
        return this.possibleMoves;
    }
}
