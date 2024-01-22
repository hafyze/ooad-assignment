package com.talabia.model.piece;

import com.talabia.model.board.Square;

import java.util.ArrayList;

public class Sun extends AbstractPiece{
    public Sun(PieceColor pieceColor) {
        super("Sun", pieceColor);
        this.pieceImageName = pieceColor.toString() + "_" + pieceName;
    }

    @Override
    public void setPossibleMoves(Square currentSquare, Square[][] squares) {
        ArrayList<Square> possibleMoves = new ArrayList<>();

        int currentRow = currentSquare.getRow();
        int currentCol = currentSquare.getColumn();
//        System.out.println(currentRow + " " + currentCol);
        for(int row = currentRow - 1; row <= currentRow + 1; row++){
            for(int col = currentCol - 1;  col <= currentCol + 1; col ++){
                if(row < 0 || row > 5 || col < 0 || col > 6){
                    continue;
                } else if (row == currentRow && col == currentCol) {
                    continue;
                }
                else{
                    if(squares[row][col].isOccupied() != false && squares[row][col].getPiece().getPieceColor() == this.pieceColor){
                        continue;
                    }
                    else{
                        possibleMoves.add(squares[row][col]);
                    }
                }
            }
        }
        this.possibleMoves = possibleMoves;
    }

    @Override
    public ArrayList<Square> getPossibleMoves() {
        return possibleMoves;
    }
}
