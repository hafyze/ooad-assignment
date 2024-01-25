package com.talabia.model.board;

import com.talabia.model.piece.*;


public class Board {
    private static final int BOARD_ROW = 6;
    private static final int BOARD_COL = 7;

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


        boardSquares[2][5] = new Square(2,5, new Point(PieceColor.DARK));
        boardSquares[5][6] = new Square(5,6, new Point(PieceColor.LIGHT));
        boardSquares[5][1] = new Square(5,1, new Hour(PieceColor.DARK));
        boardSquares[1][4] = new Square(1,4, new Hour(PieceColor.LIGHT));

    }

    public Square[][] getBoardSquares() {
        return boardSquares;
//        return currentBottomBoardColor == PieceColor.LIGHT ? boardSquares : flipBoardSquares;
    }

    public PieceColor getCurrentBottomBoardColor() {
        return currentBottomBoardColor;
    }

    public void switchBottomBoardColor(){
        currentBottomBoardColor = (currentBottomBoardColor == PieceColor.LIGHT) ? PieceColor.DARK : PieceColor.LIGHT;
//        setFlipBoardSquares();
    }

//    public void setFlipBoardSquares(){
//        for(int row = 0; row < BOARD_ROW; row ++){
//            for(int col = 0; col < BOARD_COL; col++){
//                flipBoardSquares[row][col] = boardSquares[BOARD_ROW-1-row][BOARD_COL-1-col];
//            }
//        }
//    }

//    public void changeState(){
//        Square tempSquare;
//        // From Light to Dark
//        if(currentBottomBoardColor == PieceColor.DARK){
//            for(int row = 0; row < BOARD_ROW; row++){
//                for (int col = 0; col < BOARD_COL; col++){
//                    boardSquares[row][col].;
//                }
//            }
//        }
//    }
}
