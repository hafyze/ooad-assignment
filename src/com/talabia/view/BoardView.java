package com.talabia.view;

import com.talabia.model.board.Board;
import com.talabia.model.board.Square;
import com.talabia.model.piece.PieceColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
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
                    squares[row][col].setDisabledIcon(icon);
                    if(board.getBoardSquares()[row][col].getPiece().getPieceColor() != board.getCurrentPieceColor()){
                        squares[row][col].setEnabled(false);
                    }
                }
                squares[row][col].setBackground(new Color(255, 255, 255));
                add(squares[row][col]);
            }
        }
    }

    public void showPossibleMoves(ArrayList<Square> possibleMoves){
        int possibleMovesLength = possibleMoves.size();
        for(int i = 0; i < possibleMovesLength; i++){
            int row = possibleMoves.get(i).getRow();
            int col = possibleMoves.get(i).getColumn();

            squares[row][col].setEnabled(true);
            squares[row][col].setBackground(new Color(163, 239, 87));
        }
    }

    public void updateView(){
        removeAll();
        for(int row = 0; row < board.getBoardRow(); row++){
            for(int col = 0; col < board.getBoardCol(); col++){
                int newRow = row;
                int newCol = col;

                if(board.getCurrentPieceColor() == PieceColor.DARK){
                    newRow = board.getBoardRow() - 1 - row;
                    newCol = board.getBoardCol() - 1 - col;
                }
                squares[newRow][newCol].setBackground(new Color(255, 255, 255));
                if(board.getBoardSquares()[newRow][newCol].isOccupied()!=false){
                    String pieceImageName = board.getBoardSquares()[newRow][newCol].getPiece().getPieceImageName();
                    ImageIcon icon = loadImage(pieceImageName);
                    squares[newRow][newCol].setIcon(icon);
                    squares[newRow][newCol].setEnabled(true);
                    squares[newRow][newCol].setDisabledIcon(icon);
                    if(board.getBoardSquares()[newRow][newCol].getPiece().getPieceColor() != board.getCurrentPieceColor()){
                        squares[newRow][newCol].setEnabled(false);
                    }
                }
                else {
                    squares[newRow][newCol].setIcon(null);
                    squares[newRow][newCol].setEnabled(false);
                }
                add(squares[newRow][newCol]);
            }
        }
        revalidate();
        repaint();
    }

    public void updateView(ArrayList<Square> possibleMoves){
        updateView();
        showPossibleMoves(possibleMoves);
    }

    private ImageIcon loadImage(String path){
        String relativePath = "/com/talabia/picture/" + path + ".png";
        Image image = new ImageIcon(this.getClass().getResource(relativePath)).getImage();
        Image scaledImage = image.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    public void addSquareListener(ActionListener listener){
        for(int row = 0; row < board.getBoardRow(); row++){
            for(int col = 0; col < board.getBoardCol(); col++){
                if(board.getBoardSquares()[row][col].isOccupied()!=false &&
                        board.getBoardSquares()[row][col].getPiece().getPieceColor() == board.getCurrentPieceColor()){
                    squares[row][col].setEnabled(true);
                }
                squares[row][col].addActionListener(listener);
            }
        }
    }

}
