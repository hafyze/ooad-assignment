package com.talabia.model.piece;

import com.talabia.model.board.Square;

import java.util.ArrayList;

public class Time extends AbstractPiece {

    public Time(PieceColor pieceColor) {
        super("Time", pieceColor);
        this.pieceImageName = pieceColor.toString() + "_" + pieceName;
    }

    @Override
    public void setPossibleMoves(Square currentSquare, Square[][] squares) {
        ArrayList<Square> possibleMoves = new ArrayList<>();

        int numRow = currentSquare.getRow();
        int numCol = currentSquare.getColumn();

        // Check diagonal movements
        for (int rowDirection : new int[]{-1, 1}) {
            for (int colDirection : new int[]{-1, 1}) {
                int row = numRow + rowDirection;
                //Logging
//                System.out.println("RowDirection: "+rowDirection);
//                System.out.println("numRow: "+numRow);
//                System.out.println("Row: "+row);
                int col = numCol + colDirection;

                while (row >= 0 && row < squares.length && col >= 0 && col < squares[0].length) {
                    Square square = squares[row][col];
                    possibleMoves.add(square);

                    //Updates to next square
                    row += rowDirection;
                    col += colDirection;

                    if (square.isOccupied()){
                        break;
                    }
                }
            }
        }

        this.possibleMoves = possibleMoves;
    }

    @Override
    public ArrayList<Square> getPossibleMoves() {
        return this.possibleMoves;
    }
}

