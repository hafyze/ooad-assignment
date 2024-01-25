package com.talabia.model.board;

import com.talabia.model.piece.*;


public class Board {
    private static final int BOARD_ROW = 6;
    private static final int BOARD_COL = 7;
    private static final int TURNS_TO_SWITCH = 8;

    private int turnCounter = 0;


    private final Square[][] boardSquares;
//    private final Square[][] flipBoardSquares;

    private PieceColor currentBottomBoardColor;

    public Board(){
        boardSquares = new Square[BOARD_ROW][BOARD_COL];
//        flipBoardSquares = new Square[BOARD_ROW][BOARD_COL];

        resetBoard();
        currentBottomBoardColor = PieceColor.LIGHT;
    }

    public int getBoardRow(){
        return BOARD_ROW;
    }

    public int getBoardCol(){
        return BOARD_COL;
    }

    public void resetBoard(){
        for(int row = 0; row < BOARD_ROW; row++){
            for(int col = 0; col < BOARD_COL; col++){
                boardSquares[row][col] = new Square(row, col);
            }
        }

        boardSquares[0][5] = new Square(0,5, new Plus(PieceColor.DARK));
        boardSquares[1][4] = new Square(1,4, new Time(PieceColor.DARK));
        boardSquares[5][5] = new Square(5,5, new Plus(PieceColor.LIGHT));
        boardSquares[4][5] = new Square(4,5, new Time(PieceColor.LIGHT));
    }

    public Square[][] getBoardSquares() {
        return boardSquares;
    }

    public PieceColor getCurrentBottomBoardColor() {
        return currentBottomBoardColor;
    }

    public void switchBottomBoardColor(){
        currentBottomBoardColor = (currentBottomBoardColor == PieceColor.LIGHT) ? PieceColor.DARK : PieceColor.LIGHT;
    }

    public void incrementTurnCounter(){
        turnCounter++;
        switchPieceType();
    }


    public void switchPieceType() {
        System.out.println(turnCounter);

        if (turnCounter % TURNS_TO_SWITCH == 0) {
            for (int row = 0; row < BOARD_ROW; row++) {
                for (int col = 0; col < BOARD_COL; col++) {
                    Square square = boardSquares[row][col];
                    if (square.isOccupied()) {
                        AbstractPiece currentPiece = square.getPiece();
                        System.out.println(currentPiece);
                        // Check if piece is  Time or Plus
                        if (currentPiece instanceof Time) {
                            // Replace Time with Plus
                            boardSquares[row][col].setPiece(new Plus(currentPiece.getPieceColor()), true);
                        } else if (currentPiece instanceof Plus) {
                            // Replace Plus with Time
                            boardSquares[row][col].setPiece(new Time(currentPiece.getPieceColor()), true);
                        }
                    }
                }
            }
        }
    }
}
