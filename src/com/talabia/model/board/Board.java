package com.talabia.model.board;

import java.io.*;


import com.talabia.model.piece.*;
import com.talabia.view.BoardView;
public class Board {
    private static final int BOARD_ROW = 6;
    private static final int BOARD_COL = 7;

    private final Square[][] boardSquares;
    //private final Square[][] flipBoardSquares;

    private PieceColor currentPieceColor;

    public Board(){
        boardSquares = new Square[BOARD_ROW][BOARD_COL];
        //flipBoardSquares = new Square[BOARD_ROW][BOARD_COL];

        resetBoard();
        currentPieceColor = PieceColor.LIGHT;
    }

    public int getBoardRow(){
        return BOARD_ROW;
    }

    public int getBoardCol(){
        return BOARD_COL;
    }

    public void resetBoard(){
//        boardSquares[5][0] = new Square(new Location(5,0), new Plus(PieceColor.LIGHT));
//        boardSquares[5][1] = new Square(new Location(5,1), new Hour(PieceColor.LIGHT));
//        boardSquares[5][2] = new Square(new Location(5,2), new Time(PieceColor.LIGHT));
//        boardSquares[5][3] = new Square(new Location(5,3), new Sun(PieceColor.LIGHT));
//        boardSquares[5][4] = new Square(new Location(5,4), new Time(PieceColor.LIGHT));
//        boardSquares[5][5] = new Square(new Location(5,5), new Hour(PieceColor.LIGHT));
//        boardSquares[5][6] = new Square(new Location(5,6), new Plus(PieceColor.LIGHT));
//
//        for(int row = 0; row < BOARD_ROW; row++){
//            for(int col = 0; col < BOARD_COL; col++){
//                if(row != 5){
//                    boardSquares[row][col] = new Square(new Location(row, col));
//                    if (row == 4) {
//                        boardSquares[row][col] = new Square(new Location(row, col), new Point(PieceColor.LIGHT));
//                    }
//                }
//            }
//        }

        for(int row = 0; row < BOARD_ROW; row++){
            for(int col = 0; col < BOARD_COL; col++){
                boardSquares[row][col] = new Square(row, col);
            }
        }


        boardSquares[2][5] = new Square(2,5, new Sun(PieceColor.DARK));
        boardSquares[5][6] = new Square(5,6, new Sun(PieceColor.LIGHT));

    }

    public void clearBoard() {
        for (int row = 0; row < boardSquares.length; row++) {
            for (int col = 0; col < boardSquares[row].length; col++) {
                boardSquares[row][col].setPiece(null,false);
            }
        }
    }

    public PieceColor findWinner() {
        // Check if the Light Sun piece is present on the board
        boolean lightSunPresent = false;
        for (int row = 0; row < BOARD_ROW; row++) {
            for (int col = 0; col < BOARD_COL; col++) {
                if (getBoardSquares()[row][col].getPiece() != null &&
                        getBoardSquares()[row][col].getPiece().getPieceName().equals("Sun") &&
                        getBoardSquares()[row][col].getPiece().getPieceColor() == PieceColor.LIGHT) {
                    lightSunPresent = true;
                    break;
                }
            }
            if (lightSunPresent) {
                break;
            }
        }
    
        // Check if the Dark Sun piece is present on the board
        boolean darkSunPresent = false;
        for (int row = 0; row < BOARD_ROW; row++) {
            for (int col = 0; col < BOARD_COL; col++) {
                if (getBoardSquares()[row][col].getPiece() != null &&
                        getBoardSquares()[row][col].getPiece().getPieceName().equals("Sun") &&
                        getBoardSquares()[row][col].getPiece().getPieceColor() == PieceColor.DARK) {
                    darkSunPresent = true;
                    break;
                }
            }
            if (darkSunPresent) {
                break;
            }
        }
    
        // Determine the winner based on the presence of Sun pieces
        if (!lightSunPresent && darkSunPresent) {
            return PieceColor.DARK;
        } else if (lightSunPresent && !darkSunPresent) {
            return PieceColor.LIGHT;
        } else {
            return null;
        }
    }

    public void saveBoard() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("BoardSave.txt"))) {
            for (int row = 0; row < boardSquares.length; row++) {
                for (int col = 0; col < boardSquares[row].length; col++) {
                    if (boardSquares[row][col].isOccupied()) {
                        String pieceName = boardSquares[row][col].getPiece().getPieceName();
                        PieceColor color = boardSquares[row][col].getPiece().getPieceColor();
                        writer.write(pieceName + " " + color + " at position (" + row + "," + col + ")\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadBoard(String filePath) {
        clearBoard();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(" at position \\(");
                String[] pieceInfo = parts[0].split(" "); 
                String pieceName = pieceInfo[0];
                PieceColor color = PieceColor.valueOf(pieceInfo[1]); 
    
                String[] position = parts[1].split(",|\\)"); 
                int row = Integer.parseInt(position[0].trim());
                int col = Integer.parseInt(position[1].trim());
    
                boardSquares[row][col].placeNewPiece(pieceName, color);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Square[][] getBoardSquares() {
//        return currentBottomBoardColor == PieceColor.LIGHT ? boardSquares : flipBoardSquares;
        return boardSquares;
    }

    public PieceColor getCurrentPieceColor() {
        return currentPieceColor;
    }

    public void switchPieceColor(){
        currentPieceColor = (currentPieceColor == PieceColor.LIGHT) ? PieceColor.DARK : PieceColor.LIGHT;
//        setFlipBoardSquares();
    }

//    public void setFlipBoardSquares(){
//        for(int row = 0; row < BOARD_ROW; row ++){
//            for(int col = 0; col < BOARD_COL; col++){
//                flipBoardSquares[row][col] = boardSquares[BOARD_ROW-1-row][BOARD_COL-1-col];
//            }
//        }
//    }

//    public void changeState(){
//        Square tempSquare;
//        // From Light to Dark
//        if(currentBottomBoardColor == PieceColor.DARK){
//            for(int row = 0; row < BOARD_ROW; row++){
//                for (int col = 0; col < BOARD_COL; col++){
//                    boardSquares[row][col].;
//                }
//            }
//        }
//    }
}
