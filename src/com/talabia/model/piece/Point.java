package com.talabia.model.piece;

import com.talabia.model.board.Square;

import java.util.ArrayList;

public class Point extends AbstractPiece {

    private boolean reversed;
    public Point(PieceColor pieceColor) {
        super("Point", pieceColor);
        this.pieceImageName = pieceColor.toString() + "_" + pieceName;
    }

    @Override
    public void setPossibleMoves(Square currentSquare, Square[][] squares) {
        ArrayList<Square> possibleMoves = new ArrayList<>();

        int currentRow = currentSquare.getRow();
        int currentCol = currentSquare.getColumn();

        if(currentSquare.getPiece().getPieceColor().toString().equals("LIGHT")){
            for(int i = 0; i <= 2; i++){
                currentRow =  currentRow - 1;
                if(currentRow >= 0){
                    if(squares[currentRow][currentCol].isOccupied() == false ){
                        possibleMoves.add(squares[currentRow][currentCol]);
                    } else if (squares[currentRow][currentCol].getPiece().getPieceColor()
                            != currentSquare.getPiece().getPieceColor()) {
                        possibleMoves.add(squares[currentRow][currentCol]);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        else {
            for(int i = 0; i < 2; i++){
                currentRow = currentRow + 1;
                if(currentRow <= 5){
                    possibleMoves.add(squares[currentRow][currentCol]);
                }
            }
        }

        this.possibleMoves = possibleMoves;
    }

    public ArrayList<Square> getPossibleMoves(){
        return this.possibleMoves;
    }

}
