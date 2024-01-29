package com.talabia.view;

import com.talabia.model.board.Board;
import com.talabia.model.board.Square;
import com.talabia.model.piece.PieceColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

// Programmers : Sumedha Endar
// This is the BoardView of our Talabia Chess Game.
// The tasks of the BoardView is take the data from the Model and performed methods
// that are related to the view.

public class BoardView extends JPanel {
    private final SquareView[][] squares;

    private Board board;

    // Programmers: Sumedha Endar
    // This is the BoardView Constructor
    public BoardView(Board board){
        this.board = board;

        squares = new SquareView[board.getBoardRow()][board.getBoardCol()];
        setLayout(new GridLayout(board.getBoardRow(), board.getBoardCol()));

        initializeSquares();
    }

    // Programmers: Sumedha Endar
    // This method is to initialize the squares, like whether this square is clickable or not.
    private void initializeSquares(){
        for(int row = 0; row < board.getBoardRow(); row++){
            for(int col = 0; col < board.getBoardCol(); col++){
                squares[row][col] = new SquareView(row, col);
                squares[row][col].setEnabled(false);
                if(board.getBoardSquares()[row][col].isOccupied()!=false){
                    String pieceImageName = board.getBoardSquares()[row][col].getPiece().getPieceImageName();
                    ImageIcon icon = loadImage(pieceImageName, false);
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

    // Programmers: Sumedha Endar
    // This method is color the squares that match the possible moves to green color.
    public void showPossibleMoves(ArrayList<Square> possibleMoves){
        int possibleMovesLength = possibleMoves.size();
        for(int i = 0; i < possibleMovesLength; i++){
            int row = possibleMoves.get(i).getRow();
            int col = possibleMoves.get(i).getColumn();

            squares[row][col].setEnabled(true);
            squares[row][col].setBackground(new Color(163, 239, 87));
        }
    }

    // Programmers: Sumedha Endar
    // This method is to reflect the change of the view.
    public void updateView(){
        removeAll();
        for(int row = 0; row < board.getBoardRow(); row++){
            for(int col = 0; col < board.getBoardCol(); col++){
                // LIGHT bottom - DARK top
                int newRow = row;
                int newCol = col;
                boolean flip = false;

                // DARK bottom - LIGHT top
                if(board.getCurrentPieceColor() == PieceColor.DARK){
                    newRow = board.getBoardRow() - 1 - row;
                    newCol = board.getBoardCol() - 1 - col;
                    flip = true;
                }
                squares[newRow][newCol].setBackground(new Color(255, 255, 255));
                if(board.getBoardSquares()[newRow][newCol].isOccupied()!=false){
                    String pieceImageName = board.getBoardSquares()[newRow][newCol].getPiece().getPieceImageName();
                    ImageIcon icon = loadImage(pieceImageName, flip);
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

    // Programmers: Sumedha Endar
    // This method is to reflect the change of the view
    // and color the possible move squares.
    public void updateView(ArrayList<Square> possibleMoves){
        updateView();
        showPossibleMoves(possibleMoves);
    }

    // Programmers: Sumedha Endar
    // This method is to load the image of the pieces
    private ImageIcon loadImage(String path, boolean flip) {
        double angleDegrees = flip ? 180 : 0;

        String relativePath = "/com/talabia/picture/" + path + ".png";
        Image originalImage = new ImageIcon(this.getClass().getResource(relativePath)).getImage();

        // Convert ToolkitImage to BufferedImage
        BufferedImage bufferedImage = new BufferedImage(originalImage.getWidth(null), originalImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(originalImage, 0, 0, null);
        g2d.dispose();

        // Rotate the image
        double angleRadians = Math.toRadians(angleDegrees);
        AffineTransform tx = AffineTransform.getRotateInstance(angleRadians, bufferedImage.getWidth() / 2.0, bufferedImage.getHeight() / 2.0);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        Image rotatedImage = op.filter(bufferedImage, null);

        // Scale the rotated image
        Image scaledImage = rotatedImage.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);

        return new ImageIcon(scaledImage);
    }

    // Programmers: Sumedha Endar
    // This method is to register the SquareViews to the SquareViewListener
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
