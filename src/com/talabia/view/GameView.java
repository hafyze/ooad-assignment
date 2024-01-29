package com.talabia.view;

import com.talabia.model.board.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

// Programmers : Sumedha Endar
// This is the GameView of our Talabia Chess Game. Actually, this more like a parent
// container for the game. Inside it got a MenuView and a BoardView.

public class GameView extends JFrame {
    private MenuView menuView;
    private BoardView boardView;

    // Programmers: Sumedha Endar
    // This is the GameView Constructor
    public GameView(Board board){
        super("Talabia Chess");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        menuView = new MenuView();
        boardView = new BoardView(board);

        add(menuView, BorderLayout.NORTH);
        add(boardView, BorderLayout.CENTER);

        setMinimumSize(new Dimension(625,675));
    }

    // Programmers: Sumedha Endar
    // These are the Setters & Getters
    public MenuView getMenuView() {
        return menuView;
    }

    public BoardView getBoardView() {
        return boardView;
    }
    // End of Setters & Getters
}
