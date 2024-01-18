package com.talabia.model.board;

import com.talabia.model.piece.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Board {
    private static final int BOARD_ROW = 6;
    private static final int BOARD_COL = 7;
    private Square[][] boardSquares = new Square[BOARD_ROW][BOARD_COL];
    private final Map<Location, Square> locationSquareMap;

    // Empty Board
    public Board(){
        locationSquareMap = new HashMap<>();
        newGame();
    }

    public int getBoardRow(){
        return BOARD_ROW;
    }

    public int getBoardCol(){
        return BOARD_COL;
    }

    public void newGame(){
        boardSquares[0][0] = new Square(new Location(0,0), new Plus(PieceColor.DARK));
        boardSquares[0][1] = new Square(new Location(0,1), new Hour(PieceColor.DARK));
        boardSquares[0][2] = new Square(new Location(0,2), new Time(PieceColor.DARK));
        boardSquares[0][3] = new Square(new Location(0,3), new Sun(PieceColor.DARK));
        boardSquares[0][4] = new Square(new Location(0,4), new Time(PieceColor.DARK));
        boardSquares[0][5] = new Square(new Location(0,5), new Hour(PieceColor.DARK));
        boardSquares[0][6] = new Square(new Location(0,6), new Plus(PieceColor.DARK));

        boardSquares[5][0] = new Square(new Location(5,0), new Plus(PieceColor.LIGHT));
        boardSquares[5][1] = new Square(new Location(5,1), new Hour(PieceColor.LIGHT));
        boardSquares[5][2] = new Square(new Location(5,2), new Time(PieceColor.LIGHT));
        boardSquares[5][3] = new Square(new Location(5,3), new Sun(PieceColor.LIGHT));
        boardSquares[5][4] = new Square(new Location(5,4), new Time(PieceColor.LIGHT));
        boardSquares[5][5] = new Square(new Location(5,5), new Hour(PieceColor.LIGHT));
        boardSquares[5][6] = new Square(new Location(5,6), new Plus(PieceColor.LIGHT));

        for(int row = 0; row < BOARD_ROW; row++){
            for(int col = 0; col < BOARD_COL; col++){
                if(row != 0 && row != 5){
                    boardSquares[row][col] = new Square(new Location(row, col));
                    if (row == 1){
                        boardSquares[row][col] = new Square(new Location(row, col), new Point(PieceColor.DARK));
                    } else if (row == 4) {
                        boardSquares[row][col] = new Square(new Location(row, col), new Point(PieceColor.LIGHT));
                    }
                }
                locationSquareMap.put(boardSquares[row][col].getLocation(), boardSquares[row][col]);
            }
        }
//        Square square = new Square(new Location(5,3));
//        square.setPiece(new Point(PieceColor.LIGHT));
//        getLocationSquareMap().put(square.getLocation(), square);
    }

    public Map<Location, Square> getLocationSquareMap() {
        return locationSquareMap;
    }
}
