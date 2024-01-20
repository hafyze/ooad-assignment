package com.talabia.controller;

import com.talabia.model.board.Board;
import com.talabia.model.board.Square;
import com.talabia.model.piece.AbstractPiece;
import com.talabia.view.GameView;
import com.talabia.view.SquareView;

import java.awt.event.*;
import java.util.ArrayList;

public class GameController {
    private GameView theView;
    private Board theModel;
    private ArrayList<Square> possibleMoves;
    private Square currentSquare;
    private AbstractPiece currentPiece;

    public GameController(GameView theView, Board theModel){
        this.theView = theView;
        this.theModel = theModel;

        theView.getBoardView().addSquareListener(new SquareViewListener());
    }

    private class SquareViewListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            SquareView clickedSquare = (SquareView) e.getSource();
            int row = clickedSquare.getRow();
            int col = clickedSquare.getCol();

//            System.out.println(theModel.getCurrentBottomBoardColor());
            Square chosenSquare = theModel.getBoardSquares()[row][col];

            if(chosenSquare.isOccupied() != false &&
                    chosenSquare.getPiece().getPieceColor() == theModel.getCurrentBottomBoardColor()){
                currentSquare = chosenSquare;
                currentPiece = currentSquare.getPiece();
                currentPiece.setPossibleMoves(currentSquare,theModel.getBoardSquares());
                possibleMoves = currentPiece.getPossibleMoves();
                theView.getBoardView().updateView(possibleMoves);
            }

            if(chosenSquare.isOccupied() == false ||
                    chosenSquare.getPiece().getPieceColor() != theModel.getCurrentBottomBoardColor()){
                theModel.getBoardSquares()[currentSquare.getRow()][currentSquare.getColumn()].setPiece(null, false);
                theModel.getBoardSquares()[row][col].setPiece(currentPiece, true);
                theModel.switchBottomBoardColor();
                theView.getBoardView().updateView();
            }
        }
    }
}
