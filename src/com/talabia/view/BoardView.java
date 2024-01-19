package com.talabia.view;

import com.talabia.model.board.Board;
import com.talabia.model.board.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class BoardView extends JPanel {
    private final SquareView[][] squares;
    private Board board;

    public BoardView(Board board){
        this.board = board;

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
                squares[row][col].setBackground(new Color(229, 221, 221));
                add(squares[row][col]);
            }
        }
    }

    public void updateView(){
        for(int row = 0; row < board.getBoardRow(); row++){
            for(int col = 0; col < board.getBoardCol(); col++){
                squares[row][col].setEnabled(false);
                if(board.getBoardSquares()[row][col].isOccupied()!=false){
                    String pieceImageName = board.getBoardSquares()[row][col].getPiece().getPieceImageName();
                    ImageIcon icon = loadImage(pieceImageName);
                    squares[row][col].setIcon(icon);
                    squares[row][col].setEnabled(true);
                }
                squares[row][col].setBackground(new Color(229, 221, 221));
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
            }
        }
    }

    public void showCandidateSquareView(ArrayList<Square> candidateSquares){
        int theCandidateSquaresLength = candidateSquares.size();
        updateView();
        for(int i = 0; i < theCandidateSquaresLength; i++){
            int row = candidateSquares.get(i).getRow();
            int col = candidateSquares.get(i).getColumn();
            squares[row][col].setBackground(new Color(127,255,0));
        }
    }
}
