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

// Programmers : Sumedha Endar
// This is the Controller in our Talabia Chess Game.
// The Controller coordinates interactions between the View and the Model

public class GameController {
    private GameView theView;
    private Board theModel;
    private ArrayList<Square> possibleMoves;
    private Square currentSquare;
    private AbstractPiece currentPiece;

    // Programmers: Sumedha Endar
    // This is the Controller Constructor
    public GameController(GameView theView, Board theModel){
        this.theView = theView;
        this.theModel = theModel;

        // Tell the view that when ever the New button, Save button and Load button is clicked
        // to execute the actionPerformed method in the SquareViewListener inner class
        theView.getMenuView().addNewBoardListener(new NewBoardListener());
        theView.getMenuView().addLoadBoardListener(new LoadBoardListener());
        theView.getMenuView().addSaveBoardListener(new SaveBoardListener());

        // Tell the view that when ever the SquareView is clicked to execute the actionPerformed
        // method in the SquareViewListener inner class
        theView.getBoardView().addSquareListener(new SquareViewListener());
    }

    // Programmers: Sumedha Endar, Iyad Najimi
    // This is the SquareViewListener inner class, it purposes is to execute the actionPerformed
    // method when a SquareView in the board is clicked.
    private class SquareViewListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            SquareView clickedSquare = (SquareView) e.getSource();
            int row = clickedSquare.getRow();
            int col = clickedSquare.getCol();

            Square chosenSquare = theModel.getBoardSquares()[row][col];

            // First choose a piece to move.
            // When a piece is clicked, the possible moves of the pieces will be colored in green.
            if(chosenSquare.isOccupied() != false &&
                    chosenSquare.getPiece().getPieceColor() == theModel.getCurrentPieceColor()){
                currentSquare = chosenSquare;
                currentPiece = currentSquare.getPiece();
                currentPiece.setPossibleMoves(currentSquare,theModel.getBoardSquares());
                possibleMoves = currentPiece.getPossibleMoves();
                theView.getBoardView().updateView(possibleMoves);
            }

            // Second choose a square to move.
            // When a piece is selected, click one of the possible moves to move the chosen piece.
            if (chosenSquare.isOccupied() == false ||
                    chosenSquare.getPiece().getPieceColor() != theModel.getCurrentPieceColor()) {
                theModel.getBoardSquares()[currentSquare.getRow()][currentSquare.getColumn()].setPiece(null, false);
                theModel.getBoardSquares()[row][col].setPiece(currentPiece, true);
                theModel.incrementTurnCounter();
                theModel.switchPieceColor();
                theView.getBoardView().updateView();

                // Check for winner after each move
                PieceColor winner = theModel.findWinner();
                if (winner != null) {
                    JOptionPane.showMessageDialog(null, winner + " has won!", "Game Over", JOptionPane.PLAIN_MESSAGE);
                    return;
                }
            }
        }
    }

    // Programmers: Iyad Najimi
    // This is the NewBoardListener inner class, it purposes is to execute the actionPerformed
    // method when the "New" button in the menu view is clicked.
    private class NewBoardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            theModel.resetBoard();
            theModel.switchPieceColor();
            theView.getBoardView().updateView();
        }
    }

    // Programmers: Iyad Najimi
    // This is the LoadBoardListener inner class, it purposes is to execute the actionPerformed
    // method when the "Load" button in the menu view is clicked.
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

    // Programmers: Iyad Najimi
    // This is the SaveBoardListener inner class, it purposes is to execute the actionPerformed
    // method when the "Save" button in the menu view is clicked.
    private class SaveBoardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Save");
            theModel.saveBoard();
        }
    }
}