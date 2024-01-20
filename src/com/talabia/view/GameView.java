package com.talabia.view;

import com.talabia.model.board.Board;

import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    private MenuView menuView;
    private BoardView boardView;

    public GameView(Board board){
        super("Talabia Chess");
        setSize(500,500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        menuView = new MenuView();
        boardView = new BoardView(board);

        add(menuView, BorderLayout.NORTH);
        add(boardView, BorderLayout.CENTER);
    }

    public MenuView getMenuView() {
        return menuView;
    }

    public BoardView getBoardView() {
        return boardView;
    }
}