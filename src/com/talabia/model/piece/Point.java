package com.talabia.model.piece;

import com.talabia.model.board.Square;

import java.util.ArrayList;

// Programmers : Afiq
// This is the Point Piece Model in our Talabia Chess Game.
// It extends the AbstractPiece superclass. The main purpose of this class is to set the
// unique movement for the Point Pieces.

public class Point extends AbstractPiece {
    private boolean reversed;

    // Programmers: Afiq
    // This is the Point Piece Constructor
    public Point(PieceColor pieceColor) {
        super("Point", pieceColor);
        this.pieceImageName = pieceColor.toString() + "_" + pieceName;
        this.reversed = false;
    }

    // Programmers: Afiq
    // To calculate and set the possible moves of the Point
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

    // Programmers: Afiq
    // MovementOne is from (5,6) to (0,0)
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

    // Programmers: Afiq
    // MovementTwo is from (0,0) to (5,6)
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

