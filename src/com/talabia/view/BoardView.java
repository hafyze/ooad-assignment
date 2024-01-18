package com.talabia.view;

import com.talabia.model.board.Board;
import com.talabia.model.board.Location;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Objects;

public class BoardView extends JPanel {
    private final JButton[][] squares;
    private Board board;

    public BoardView(Board board){
        this.board = board;

        setLayout(new GridLayout(board.getBoardRow(), board.getBoardCol()));
        squares = new JButton[board.getBoardRow()][board.getBoardCol()];

        for(int row = 0; row < board.getBoardRow(); row++){
            for(int col = 0; col < board.getBoardCol(); col++){
                squares[row][col] = new JButton();
                if(board.getLocationSquareMap().get(new Location(row, col)).isOccupied() != false){
                    String pieceImageName = board.getLocationSquareMap().get(new Location(row, col)).getPiece().getPieceImageName();
                    System.out.println(pieceImageName);
                    ImageIcon icon = loadImage(pieceImageName);
                    squares[row][col].setIcon(icon);
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
}
