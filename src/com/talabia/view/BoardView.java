package com.talabia.view;

import com.talabia.model.board.Board;
import com.talabia.model.board.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BoardView extends JPanel {
    private final SquareView[][] squares;
    private static ArrayList<Square> possibleMoves;
    private Board board;

    public BoardView(Board board){
        this.board = board;
        this.possibleMoves = new ArrayList<>();

        squares = new SquareView[board.getBoardRow()][board.getBoardCol()];
        setLayout(new GridLayout(board.getBoardRow(), board.getBoardCol()));

        initializeSquares();
    }

    private void initializeSquares(){
        for(int row = 0; row < board.getBoardRow(); row++){
            for(int col = 0; col < board.getBoardCol(); col++){
                squares[row][col] = new SquareView(row, col);
                squares[row][col].setEnabled(false);
                if(board.getBoardSquares()[row][col].isOccupied()!=false){
                    String pieceImageName = board.getBoardSquares()[row][col].getPiece().getPieceImageName();
                    ImageIcon icon = loadImage(pieceImageName);
                    squares[row][col].setIcon(icon);
                    squares[row][col].setEnabled(true);
                }
                squares[row][col].setBackground(new Color(255, 255, 255));
                add(squares[row][col]);
            }
        }
    }

    public void updateView(){
        for(int row = 0; row < board.getBoardRow(); row++){
            for(int col = 0; col < board.getBoardCol(); col++){
                squares[row][col].setEnabled(false);
                squares[row][col].setIcon(null);
                if(board.getBoardSquares()[row][col].isOccupied()!=false){
                    String pieceImageName = board.getBoardSquares()[row][col].getPiece().getPieceImageName();
                    ImageIcon icon = loadImage(pieceImageName);
                    squares[row][col].setIcon(icon);
                    squares[row][col].setEnabled(true);
                }
                squares[row][col].setBackground(new Color(255, 255, 255));
                add(squares[row][col]);
            }
        }
    }

    private ImageIcon loadImage(String path){
        String relativePath = "/com/talabia/picture/" + path + ".png";
        System.out.println(relativePath);
        Image image = new ImageIcon(this.getClass().getResource(relativePath)).getImage();
        Image scaledImage = image.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    public void addSquareListener(ActionListener listener){
        for(int row = 0; row < board.getBoardRow(); row++){
            for(int col = 0; col < board.getBoardCol(); col++){
                squares[row][col].addActionListener(listener);
                squares[row][col].setEnabled(true);
            }
        }
    }

    public void addMovePieceListener(ActionListener listener){
        int thePossibleMovesLength = possibleMoves.size();
        for(int i = 0; i < thePossibleMovesLength; i++){
            int row = possibleMoves.get(i).getRow();
            int col = possibleMoves.get(i).getColumn();
            squares[row][col].setEnabled(true);
            squares[row][col].addActionListener(listener);
        }
        System.out.println(thePossibleMovesLength);
    }

    public void showCandidateSquareView(ArrayList<Square> candidateSquares){
        this.possibleMoves = candidateSquares;
        int theCandidateSquaresLength = candidateSquares.size();
        updateView();
        for(int i = 0; i < theCandidateSquaresLength; i++){
            int row = candidateSquares.get(i).getRow();
            int col = candidateSquares.get(i).getColumn();
            squares[row][col].setBackground(new Color(163, 239, 87));
        }
    }
}