package com.talabia.Application;

import com.talabia.controller.GameController;
import com.talabia.model.board.Board;
import com.talabia.view.GameView;

public class GameMVC {
    public static void main(String[] args){
        Board theModel = new Board();
        GameView theView = new GameView(theModel);
        GameController theController = new GameController(theView, theModel);

        theView.setVisible(true);
    }
}
