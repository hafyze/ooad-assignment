package com.talabia.model.Runner;

import com.talabia.model.board.Square;
import com.talabia.model.piece.PieceColor;
import com.talabia.model.piece.Point;

public class Test1 {
    public static void main(String[] args){
        Square square = new Square(2,3, new Point(PieceColor.LIGHT));
//        System.out.println(square.getLocation().getRow() + " " + square.getLocation().getCol());
//        System.out.println(square.getPiece().getPieceName() + " " + square.getPiece().getPieceColor());
//        System.out.println(square.isOccupied());
        System.out.println(square);
    }
}
