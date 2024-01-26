package com.talabia.model.board;

import com.talabia.model.piece.*;

import java.io.*;


public class Board {
    private static final int BOARD_ROW = 6;
    private static final int BOARD_COL = 7;
    private static final int TURNS_TO_SWITCH = 4;

    private int turnCounter = 0;


    private final Square[][] boardSquares;
//    private final Square[][] flipBoardSquares;

    private PieceColor currentPieceColor;

    public Board(){
        boardSquares = new Square[BOARD_ROW][BOARD_COL];
//        flipBoardSquares = new Square[BOARD_ROW][BOARD_COL];

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
        for(int row = 0; row < BOARD_ROW; row++){
            for(int col = 0; col < BOARD_COL; col++){
                boardSquares[row][col] = new Square(row, col);
                if (row == 4) {
                    boardSquares[row][col] = new Square(row, col, new Point(PieceColor.LIGHT));
                } else if (row == 1) {
                    boardSquares[row][col] = new Square(row, col, new Point(PieceColor.DARK));
                }
            }
        }
        turnCounter=0;
        boardSquares[0][0] = new Square(0,0, new Plus(PieceColor.DARK));
//        boardSquares[0][1] = new Square(0,1, new Hour(PieceColor.DARK));
        boardSquares[0][2] = new Square(0,2, new Time(PieceColor.DARK));
        boardSquares[0][3] = new Square(0,3, new Sun(PieceColor.DARK));
        boardSquares[0][4] = new Square(0,4, new Time(PieceColor.DARK));
//        boardSquares[0][5] = new Square(0,5, new Hour(PieceColor.DARK));
        boardSquares[0][6] = new Square(0,6, new Plus(PieceColor.DARK));

        boardSquares[5][0] = new Square(5,0, new Plus(PieceColor.LIGHT));
//        boardSquares[5][1] = new Square(5,1, new Hour(PieceColor.LIGHT));
        boardSquares[5][2] = new Square(5,2, new Time(PieceColor.LIGHT));
        boardSquares[5][3] = new Square(5,3, new Sun(PieceColor.LIGHT));
        boardSquares[5][4] = new Square(5,4, new Time(PieceColor.LIGHT));
//        boardSquares[5][5] = new Square(5,5, new Hour(PieceColor.LIGHT));
        boardSquares[5][6] = new Square(5,6, new Plus(PieceColor.LIGHT));
    }

    public Square[][] getBoardSquares() {
        return boardSquares;
//        return currentBottomBoardColor == PieceColor.LIGHT ? boardSquares : flipBoardSquares;
    }

    public PieceColor getCurrentPieceColor() {
        return currentPieceColor;
    }

    public void switchPieceColor(){
        currentPieceColor = (currentPieceColor == PieceColor.LIGHT) ? PieceColor.DARK : PieceColor.LIGHT;
    }

    public void incrementTurnCounter(){
        turnCounter++;
        switchPieceType();
    }

//    public void setFlipBoardSquares(){
//        for(int row = 0; row < BOARD_ROW; row ++){
//            for(int col = 0; col < BOARD_COL; col++){
//                flipBoardSquares[row][col] = boardSquares[BOARD_ROW-1-row][BOARD_COL-1-col];
//            }
//        }
//    }

    public void switchPieceType() {
        System.out.println(turnCounter);
        if (turnCounter % TURNS_TO_SWITCH == 0) {
            for (int row = 0; row < BOARD_ROW; row++) {
                for (int col = 0; col < BOARD_COL; col++) {
                    Square square = boardSquares[row][col];
                    if (square.isOccupied()) {
                        AbstractPiece currentPiece = square.getPiece();
                        System.out.println(currentPiece);
                        // Check if piece is  Time or Plus
                        if (currentPiece instanceof Time) {
                            // Replace Time with Plus
                            boardSquares[row][col].setPiece(new Plus(currentPiece.getPieceColor()), true);
                        } else if (currentPiece instanceof Plus) {
                            // Replace Plus with Time
                            boardSquares[row][col].setPiece(new Time(currentPiece.getPieceColor()), true);
                        }
                    }
                }
            }
        }
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
            writer.write("Moves made:" + turnCounter + "\n");
            writer.write("Current Piece Color:" + currentPieceColor + "\n");
            for (int row = 0; row < boardSquares.length; row++) {
                for (int col = 0; col < boardSquares[row].length; col++) {
                    if (boardSquares[row][col].isOccupied()) {
                        String pieceName = boardSquares[row][col].getPiece().getPieceName();
                        writer.write(pieceName + " " + boardSquares[row][col].getPiece().getPieceColor() + " at position (" + row + "," + col + ")\n");
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
                if (line.startsWith("Moves made:")) {
                    turnCounter = Integer.parseInt(line.substring(line.lastIndexOf(":") + 1).trim());
                } else if (line.startsWith("Current Piece Color:")) {
                    currentPieceColor = PieceColor.valueOf(line.substring(line.lastIndexOf(":") + 1).trim());
                } else {
                    String[] parts = line.split(" at position \\(");
                    String[] pieceInfo = parts[0].split(" ");
                    String pieceName = pieceInfo[0];
                    PieceColor color = PieceColor.valueOf(pieceInfo[1]);
    
                    String[] position = parts[1].split(",|\\)");
                    int row = Integer.parseInt(position[0].trim());
                    int col = Integer.parseInt(position[1].trim());
    
                    boardSquares[row][col].placeNewPiece(pieceName, color);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
