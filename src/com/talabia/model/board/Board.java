package com.talabia.model.board;

import com.talabia.model.piece.*;


public class Board {
    private static final int BOARD_ROW = 6;
    private static final int BOARD_COL = 7;

    private final Square[][] boardSquares;

    private PieceColor currentBottomBoardColor;

    public Board(){
        boardSquares = new Square[BOARD_ROW][BOARD_COL];
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
//        boardSquares[5][0] = new Square(new Location(5,0), new Plus(PieceColor.LIGHT));
//        boardSquares[5][1] = new Square(new Location(5,1), new Hour(PieceColor.LIGHT));
//        boardSquares[5][2] = new Square(new Location(5,2), new Time(PieceColor.LIGHT));
//        boardSquares[5][3] = new Square(new Location(5,3), new Sun(PieceColor.LIGHT));
//        boardSquares[5][4] = new Square(new Location(5,4), new Time(PieceColor.LIGHT));
//        boardSquares[5][5] = new Square(new Location(5,5), new Hour(PieceColor.LIGHT));
//        boardSquares[5][6] = new Square(new Location(5,6), new Plus(PieceColor.LIGHT));
//
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
            }
        }
        boardSquares[4][2] = new Square(4,2, new Point(PieceColor.LIGHT));
        boardSquares[4][3] = new Square(4,3, new Point(PieceColor.LIGHT));
        boardSquares[4][1] = new Square(4,1, new Point(PieceColor.DARK));
        boardSquares[1][2] = new Square(1,2, new Point(PieceColor.LIGHT));
        boardSquares[2][2] = new Square(2,2, new Point(PieceColor.DARK));


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
}
