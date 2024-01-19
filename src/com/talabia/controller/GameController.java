package com.talabia.controller;

import com.talabia.model.board.Board;
import com.talabia.view.GameView;
import com.talabia.view.SquareView;

import java.awt.event.*;

public class GameController {
    private GameView theView;
    private Board theModel;

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

            System.out.println(row + " " + col);
            System.out.println(theModel.getBoardSquares()[row][col].getPiece()
                    .getPossibleMoves(theModel.getBoardSquares()[row][col],theModel.getBoardSquares()));
            theView.getBoardView().showCandidateSquareView(theModel.getBoardSquares()[row][col].getPiece()
                    .getPossibleMoves(theModel.getBoardSquares()[row][col],theModel.getBoardSquares()));
        }
    }


}
