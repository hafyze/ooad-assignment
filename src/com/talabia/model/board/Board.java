package com.talabia.model.board;

import com.talabia.model.piece.*;


public class Board {
    private static final int BOARD_ROW = 6;
    private static final int BOARD_COL = 7;
    private static final int TURNS_TO_SWITCH = 4;

    private int turnCounter = 0;


    private final Square[][] boardSquares;
//    private final Square[][] flipBoardSquares;

    private PieceColor currentPieceColor;

    public Board(){
        boardSquares = new Square[BOARD_ROW][BOARD_COL];
//        flipBoardSquares = new Square[BOARD_ROW][BOARD_COL];

        resetBoard();
        currentPieceColor = PieceColor.LIGHT;
    }

    public int getBoardRow(){
        return BOARD_ROW;
    }

    public int getBoardCol(){
        return BOARD_COL;
    }

    public void resetBoard(){
//        for(int row = 0; row < BOARD_ROW; row++){
//            for(int col = 0; col < BOARD_COL; col++){
//                if(row != 5){
//                    boardSquares[row][col] = new Square(new Location(row, col));
//                    if (row == 4) {
//                        boardSquares[row][col] = new Square(new Location(row, col), new Point(PieceColor.LIGHT));
//                    }
//                }
//            }
//        }

        for(int row = 0; row < BOARD_ROW; row++){
            for(int col = 0; col < BOARD_COL; col++){
                boardSquares[row][col] = new Square(row, col);
                if (row == 4) {
                    boardSquares[row][col] = new Square(row, col, new Point(PieceColor.LIGHT));
                } else if (row == 1) {
                    boardSquares[row][col] = new Square(row, col, new Point(PieceColor.DARK));
                }
            }
        }

        boardSquares[0][0] = new Square(0,0, new Plus(PieceColor.DARK));
//        boardSquares[0][1] = new Square(0,1, new Hour(PieceColor.DARK));
        boardSquares[0][2] = new Square(0,2, new Time(PieceColor.DARK));
        boardSquares[0][3] = new Square(0,3, new Sun(PieceColor.DARK));
        boardSquares[0][4] = new Square(0,4, new Time(PieceColor.DARK));
//        boardSquares[0][5] = new Square(0,5, new Hour(PieceColor.DARK));
        boardSquares[0][6] = new Square(0,6, new Plus(PieceColor.DARK));

        boardSquares[5][0] = new Square(5,0, new Plus(PieceColor.LIGHT));
//        boardSquares[5][1] = new Square(5,1, new Hour(PieceColor.LIGHT));
        boardSquares[5][2] = new Square(5,2, new Time(PieceColor.LIGHT));
        boardSquares[5][3] = new Square(5,3, new Sun(PieceColor.LIGHT));
        boardSquares[5][4] = new Square(5,4, new Time(PieceColor.LIGHT));
//        boardSquares[5][5] = new Square(5,5, new Hour(PieceColor.LIGHT));
        boardSquares[5][6] = new Square(5,6, new Plus(PieceColor.LIGHT));
    }

    public Square[][] getBoardSquares() {
        return boardSquares;
//        return currentBottomBoardColor == PieceColor.LIGHT ? boardSquares : flipBoardSquares;
    }

    public PieceColor getCurrentPieceColor() {
        return currentPieceColor;
    }

    public void switchPieceColor(){
        currentPieceColor = (currentPieceColor == PieceColor.LIGHT) ? PieceColor.DARK : PieceColor.LIGHT;
    }

    public void incrementTurnCounter(){
        turnCounter++;
        switchPieceType();
    }

//    public void setFlipBoardSquares(){
//        for(int row = 0; row < BOARD_ROW; row ++){
//            for(int col = 0; col < BOARD_COL; col++){
//                flipBoardSquares[row][col] = boardSquares[BOARD_ROW-1-row][BOARD_COL-1-col];
//            }
//        }
//    }

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
