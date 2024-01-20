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


        //horizontal
        for(int i = 0; i < board.getBoardRow(); i++){
            currentRow = currentRow - 1;
            if(currentRow >= 0) {
                possibleMoves.add(squares[currentRow][currentCol]);
            }
        }
        this.possibleMoves = possibleMoves;
    }

    @Override
    public ArrayList<Square> getPossibleMoves() {
        return this.possibleMoves;
    }
}