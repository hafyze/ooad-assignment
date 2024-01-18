package com.talabia.model.board;

import com.talabia.model.piece.PieceColor;
import com.talabia.model.piece.Plus;
import com.talabia.model.piece.Point;

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
        for(int row = 0; row < BOARD_ROW; row++){
            for(int col = 0; col < BOARD_COL; col++){
                boardSquares[row][col] = new Square(new Location(row, col));
                if (row == 1){
                    boardSquares[row][col].setPiece(new Point(PieceColor.DARK));
                } else if (row == 4) {
                    boardSquares[row][col].setPiece(new Point(PieceColor.LIGHT));
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
