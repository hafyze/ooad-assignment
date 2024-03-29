package com.talabia.model.board;

import com.talabia.model.piece.*;

import java.io.*;

// Programmers : Sumedha Endar, Iyad Najimi, Zulhafiz
// This is the Board Model in our Talabia Chess Game.
// The Board Model performs all the calculations and logics related to the Talabia Chess Board.

public class Board {
    private static final int BOARD_ROW = 6;
    private static final int BOARD_COL = 7;
    private static final int TURNS_TO_SWITCH = 4;
    private int turnCounter = 0;
    private final Square[][] boardSquares;
    private PieceColor currentPieceColor;

    // Programmers: Sumedha Endar
    // This is the Board Constructor
    public Board(){
        boardSquares = new Square[BOARD_ROW][BOARD_COL];
        resetBoard();
        currentPieceColor = PieceColor.LIGHT;
    }

    // Programmers: Sumedha Endar
    // These are the Setters & Getters
    public int getBoardRow(){
        return BOARD_ROW;
    }

    public int getBoardCol(){
        return BOARD_COL;
    }

    public Square[][] getBoardSquares() {
        return boardSquares;
    }

    public PieceColor getCurrentPieceColor() {
        return currentPieceColor;
    }
    // End of Setters & Getters

    // Programmers: Sumedha Endar, Iyad Najimi
    // The resetBoard() purposes is to place all the pieces to theirs initial position.
    public void resetBoard(){
        for(int row = 0; row < BOARD_ROW; row++){
            for(int col = 0; col < BOARD_COL; col++){
                boardSquares[row][col] = new Square(row, col);
                if (row == 4) {
                    boardSquares[row][col] = new Square(row, col, new Point(PieceColor.LIGHT));
                }
                else if (row == 1) {
                    boardSquares[row][col] = new Square(row, col, new Point(PieceColor.DARK));
                }
            }
        }
        turnCounter=0;
        boardSquares[0][0] = new Square(0,0, new Plus(PieceColor.DARK));
        boardSquares[0][1] = new Square(0,1, new Hour(PieceColor.DARK));
        boardSquares[0][2] = new Square(0,2, new Time(PieceColor.DARK));
        boardSquares[0][3] = new Square(0,3, new Sun(PieceColor.DARK));
        boardSquares[0][4] = new Square(0,4, new Time(PieceColor.DARK));
        boardSquares[0][5] = new Square(0,5, new Hour(PieceColor.DARK));
        boardSquares[0][6] = new Square(0,6, new Plus(PieceColor.DARK));

        boardSquares[5][0] = new Square(5,0, new Plus(PieceColor.LIGHT));
        boardSquares[5][1] = new Square(5,1, new Hour(PieceColor.LIGHT));
        boardSquares[5][2] = new Square(5,2, new Time(PieceColor.LIGHT));
        boardSquares[5][3] = new Square(5,3, new Sun(PieceColor.LIGHT));
        boardSquares[5][4] = new Square(5,4, new Time(PieceColor.LIGHT));
        boardSquares[5][5] = new Square(5,5, new Hour(PieceColor.LIGHT));
        boardSquares[5][6] = new Square(5,6, new Plus(PieceColor.LIGHT));
    }

    // Programmers: Sumedha Endar,
    // The switchPieceColor() is to indicate now is which color turn to move.
    public void switchPieceColor(){
        currentPieceColor = (currentPieceColor == PieceColor.LIGHT) ? PieceColor.DARK : PieceColor.LIGHT;
    }

    // Programmers: Zulhafiz
    // The incrementTurnCounter() is to count the number of rounds and switch the
    // Plus and Time when two rounds or four turns are reached.
    public void incrementTurnCounter(){
        turnCounter++;
        switchPieceType();
    }

    // Programmers: Zulhafiz
    // The switchPieceType() is to switch the Plus and Time when two rounds or four turns are reached.
    public void switchPieceType() {
        if (turnCounter % TURNS_TO_SWITCH == 0) {
            for (int row = 0; row < BOARD_ROW; row++) {
                for (int col = 0; col < BOARD_COL; col++) {
                    Square square = boardSquares[row][col];
                    if (square.isOccupied()) {
                        AbstractPiece currentPiece = square.getPiece();
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

    // Programmers: Iyad Najimi
    // The clearBoard() is to clear the board of any pieces
    public void clearBoard() {
        for (int row = 0; row < boardSquares.length; row++) {
            for (int col = 0; col < boardSquares[row].length; col++) {
                boardSquares[row][col].setPiece(null,false);
                //Traverse all squares and empties it
            }
        }
    }

    // Programmers: Iyad Najimi
    // The findWinner() is to find the Winner
    public PieceColor findWinner() {
        // Check if the Light Sun piece is present on the board
        boolean lightSunPresent = false; //boolean to verify Light Sun Piece existence
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
        boolean darkSunPresent = false; //boolean to verify Dark Sun Piece existence
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
            return null; // if both still present continue game
        }
    }

    // Programmers: Iyad Najimi
    // The saveBoard() is to save the current board by saves the pieces locations,
    // moves made and current turn into a txt file
    public void saveBoard() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("BoardSave.txt"))) {
            writer.write("Moves made:" + turnCounter + "\n");
            writer.write("Current Piece Color:" + currentPieceColor + "\n");
            for (int row = 0; row < boardSquares.length; row++) {
                for (int col = 0; col < boardSquares[row].length; col++) {
                    if (boardSquares[row][col].isOccupied()) {
                        //traversing squares to find pieces and record the position of it
                        String pieceName = boardSquares[row][col].getPiece().getPieceName();
                        writer.write(pieceName + " " + boardSquares[row][col].getPiece().getPieceColor() + " at position (" + row + "," + col + ")\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Programmers: Iyad Najimi
    // The loadBoard() is to load the previous board by loads the positions of pieces
    // from the txt file
    public void loadBoard(String filePath) {
        clearBoard(); //clears the board so new pieces can be created
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
