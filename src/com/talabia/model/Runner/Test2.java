package com.talabia.model.Runner;

import com.talabia.model.board.Board;
import com.talabia.model.board.Location;
import com.talabia.model.board.Square;
import com.talabia.model.piece.PieceColor;
import com.talabia.model.piece.Point;

public class Test2 {
    public static void main(String[] args){
        Board board = new Board();
        Square square = new Square(new Location(2,3));
        square.setPiece(new Point(PieceColor.LIGHT));
        board.getLocationSquareMap().put(new Location(2,3), square);

        System.out.println(board.getLocationSquareMap().get(new Location(2,3)));
    }
}
