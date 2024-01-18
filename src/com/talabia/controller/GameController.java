package com.talabia.controller;

import com.talabia.model.board.Board;
import com.talabia.view.GameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController {
    private GameView theView;
    private Board theModel;

    public GameController(GameView theView, Board theModel){
        this.theView = theView;
        this.theModel = theModel;

//        theView.getMenuView().addNewGameListener(new NewGameListener());
    }

//    private class NewGameListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            theModel.newGame();
//            theView.getBoardView().setNewBoardView(theModel);
//        }
//    }


}
