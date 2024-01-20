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

            System.out.println(row + " " + col);
            if(theModel.getBoardSquares()[row][col].isOccupied() != false){
                currentPiece = theModel.getBoardSquares()[row][col].getPiece();
                currentPiece.setPossibleMoves(theModel.getBoardSquares()[row][col],theModel.getBoardSquares());
                possibleMoves = currentPiece.getPossibleMoves();

                theView.getBoardView().showCandidateSquareView(possibleMoves);

                theView.getBoardView().addMovePieceListener(new MovePieceListener(row, col));
            }
        }
    }

    private class MovePieceListener implements ActionListener{
        private int currentRow;
        private int currentCol;

        MovePieceListener(int currentRow, int currentCol){
            this.currentRow = currentRow;
            this.currentCol = currentCol;
            System.out.println(currentPiece);
        }
        @Override
        public void actionPerformed(ActionEvent e){
            SquareView clickedSquare = (SquareView) e.getSource();
            int finalRow = clickedSquare.getRow();
            int finalCol = clickedSquare.getCol();

            theModel.getBoardSquares()[currentRow][currentCol].setPiece(null, false);
            theModel.getBoardSquares()[finalRow][finalCol].setPiece(currentPiece, true);
        }
    }
}