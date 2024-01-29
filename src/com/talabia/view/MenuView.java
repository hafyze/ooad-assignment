package com.talabia.view;
import com.talabia.model.board.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.*;

public class MenuView extends JPanel {
    private JButton newBtn;
    private JButton saveBtn;
    private JButton loadBtn;

    public MenuView(){
        newBtn = new JButton("New");
        saveBtn = new JButton("Save");
        loadBtn = new JButton("Load");

        add(newBtn);
        add(loadBtn);
        add(saveBtn);
    }

    // Programmers: Iyad Najimi
    // This method is to register the newBtn to the NewBoardListener in the GameController
    public void addNewBoardListener(ActionListener listenerForNewBtn){
        newBtn.addActionListener(listenerForNewBtn);
    }

    // Programmers: Iyad Najimi
    // This method is to register the saveBtn to the SaveBoardListener in the GameController
    public void addSaveBoardListener(ActionListener listenerForSaveBtn){
        saveBtn.addActionListener(listenerForSaveBtn);
    }

    // Programmers: Iyad Najimi
    // This method is to register the loadBtn to the LoadBoardListener in the GameController
    public void addLoadBoardListener(ActionListener listenerForLoadBtn){
        loadBtn.addActionListener(listenerForLoadBtn);
    }
}

