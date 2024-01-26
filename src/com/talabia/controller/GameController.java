package com.talabia.controller;

import com.talabia.model.board.Board;
import com.talabia.model.board.Square;
import com.talabia.model.piece.AbstractPiece;
import com.talabia.model.piece.PieceColor;
import com.talabia.view.GameView;
import com.talabia.view.SquareView;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;

import javax.swing.JOptionPane;

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
        theView.getMenuView().addNewBoardListener(new NewBoardListener());
        theView.getMenuView().addLoadBoardListener(new LoadBoardListener());
        theView.getMenuView().addSaveBoardListener(new SaveboardListener());
    }

    private class SquareViewListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            SquareView clickedSquare = (SquareView) e.getSource();
            int row = clickedSquare.getRow();
            int col = clickedSquare.getCol();

//            System.out.println(theModel.getBoardSquares()[row][col]);
            Square chosenSquare = theModel.getBoardSquares()[row][col];

            if(chosenSquare.isOccupied() != false &&
                    chosenSquare.getPiece().getPieceColor() == theModel.getCurrentPieceColor()){
                currentSquare = chosenSquare;
                currentPiece = currentSquare.getPiece();
                currentPiece.setPossibleMoves(currentSquare,theModel.getBoardSquares());
                possibleMoves = currentPiece.getPossibleMoves();
                theView.getBoardView().updateView(possibleMoves);
            }

            if (chosenSquare.isOccupied() == false ||
                    chosenSquare.getPiece().getPieceColor() != theModel.getCurrentPieceColor()) {
//                if(theModel.getCurrentBottomBoardColor() == PieceColor.LIGHT){
//                    theModel.getBoardSquares()[currentSquare.getRow()][currentSquare.getColumn()].setPiece(null, false);
//                    theModel.getBoardSquares()[row][col].setPiece(currentPiece, true);
//                }
//                else{
//                    System.out.println(currentSquare.getRow() + " " +currentSquare.getColumn());
//                    System.out.println(row + " " + col);
//                    theModel.getBoardSquares()[theModel.getBoardRow() - 1 - currentSquare.getRow()][theModel.getBoardCol() - 1 - currentSquare.getColumn()].setPiece(null, false);
//                    theModel.getBoardSquares()[row][col].setPiece(currentPiece, true);
//                }
                theModel.getBoardSquares()[currentSquare.getRow()][currentSquare.getColumn()].setPiece(null, false);
                theModel.getBoardSquares()[row][col].setPiece(currentPiece, true);
                theModel.switchPieceColor();
                theView.getBoardView().updateView();

                // Check for winner after each move
                //Board board = new Board();
                PieceColor winner = theModel.findWinner();
                if (winner != null) {
                    JOptionPane.showMessageDialog(null, winner + " has won!", "Game Over", JOptionPane.PLAIN_MESSAGE);
                    return;
                }
            }
        }
    }

    private class NewBoardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            theModel.resetBoard();
            theModel.switchPieceColor();
            theView.getBoardView().updateView();
        }
    }

    private class LoadBoardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Load");
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                theModel.loadBoard(selectedFile.getAbsolutePath());
                theView.getBoardView().updateView();
            }
        }
    }

    private class SaveboardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Save");
            theModel.saveBoard();
        }
    }
}