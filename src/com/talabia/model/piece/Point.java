package com.talabia.model.piece;

import com.talabia.model.board.Square;

import java.util.ArrayList;

public class Point extends AbstractPiece {

    public Point(PieceColor pieceColor) {
        super("Point", pieceColor);
        this.pieceImageName = pieceColor.toString() + "_" + pieceName;
    }

    //Comments
    @Override
    public void setPossibleMoves(Square currentSquare, Square[][] squares) {
        ArrayList<Square> possibleMoves = new ArrayList<>();

        int currentRow = currentSquare.getRow();
        int currentCol = currentSquare.getColumn();

        for(int i = 0; i < 2; i++){
            currentRow = currentRow - 1;
            if(currentRow >= 0){
                possibleMoves.add(squares[currentRow][currentCol]);
            }
        }
        this.possibleMoves = possibleMoves;
    }

    public ArrayList<Square> getPossibleMoves(){
        return this.possibleMoves;
    }

}