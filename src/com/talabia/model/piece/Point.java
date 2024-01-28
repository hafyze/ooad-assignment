package com.talabia.model.piece;

import com.talabia.model.board.Square;

import java.util.ArrayList;

public class Point extends AbstractPiece {

    private boolean reversed;
    public Point(PieceColor pieceColor) {
        super("Point", pieceColor);
        this.pieceImageName = pieceColor.toString() + "_" + pieceName;
        this.reversed = false;
    }

    @Override
    public void setPossibleMoves(Square currentSquare, Square[][] squares) {
        int currentRow = currentSquare.getRow();
        int currentCol = currentSquare.getColumn();

        if(currentSquare.getPiece().getPieceColor() == PieceColor.LIGHT){
            // To change the direction of LIGHT Point Piece
            if(!reversed && currentRow == 0){
                reversed = true;
                this.pieceImageName = pieceColor.toString() + "_" + pieceName + "_R";
            }
            else if(reversed && currentRow == 5){
                reversed = false;
                this.pieceImageName = pieceColor.toString() + "_" + pieceName;
            }
            // Different direction has different moves
            if(!reversed){
                this.possibleMoves = movementOne(currentSquare, squares, currentRow, currentCol);
            }
            else{
                this.possibleMoves = movementTwo(currentSquare, squares, currentRow, currentCol);
            }
        }
        else{
            // To change the direction of DARK Point Piece
            if(!reversed && currentRow == 5){
                reversed = true;
                this.pieceImageName = pieceColor.toString() + "_" + pieceName + "_R";
            }
            else if(reversed && currentRow == 0){
                reversed = false;
                this.pieceImageName = pieceColor.toString() + "_" + pieceName;
            }
            // Different direction has different moves
            if(!reversed){
                this.possibleMoves = movementTwo(currentSquare, squares, currentRow, currentCol);
            }
            else{
                this.possibleMoves = movementOne(currentSquare, squares, currentRow, currentCol);
            }
        }
    }

    public ArrayList<Square> getPossibleMoves(){
        return this.possibleMoves;
    }

    private ArrayList<Square> movementOne(Square currentSquare, Square[][] squares, int currentRow, int currentCol){
        ArrayList<Square> possibleMoves = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            currentRow = currentRow - 1;
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
        return possibleMoves;
    }

    private ArrayList<Square> movementTwo(Square currentSquare, Square[][] squares, int currentRow, int currentCol){
        ArrayList<Square> possibleMoves = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            currentRow = currentRow + 1;
            if(currentRow <= 5){
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
        return possibleMoves;
    }
}

