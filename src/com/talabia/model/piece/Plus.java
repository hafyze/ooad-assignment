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

        int currentRow = currentSquare.getRow();
        int currentCol = currentSquare.getColumn();

        // Move up
        for (int i = 1; i <= board.getBoardRow(); i++) {
            int newRow = currentRow - i;
            if (newRow >= 0) {
                possibleMoves.add(squares[newRow][currentCol]);
            }
        }

        // Move down
        for (int i = 1; i <= board.getBoardRow(); i++) {
            int newRow = currentRow + i;
            if (newRow < squares.length) {
                possibleMoves.add(squares[newRow][currentCol]);
            }
        }

        // Move left
        for (int i = 1; i <= board.getBoardCol(); i++) {
            int newCol = currentCol - i;
            if (newCol >= 0) {
                possibleMoves.add(squares[currentRow][newCol]);
            }
        }

        // Move right
        for (int i = 1; i <= board.getBoardCol(); i++) {
            int newCol = currentCol + i;
            if (newCol < squares[0].length) {
                possibleMoves.add(squares[currentRow][newCol]);
            }
        }

        this.possibleMoves = possibleMoves;
    }

    @Override
    public ArrayList<Square> getPossibleMoves() {
        return possibleMoves;
    }
}
