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

    public void addNewBoardListener(ActionListener listenerForNewBtn){
        newBtn.addActionListener(listenerForNewBtn);//passes the listener from controller
    }

    public void addSaveBoardListener(ActionListener listenerForSaveBtn){
        saveBtn.addActionListener(listenerForSaveBtn);//passes the listener from controller
    }

    public void addLoadBoardListener(ActionListener listenerForLoadBtn){
        loadBtn.addActionListener(listenerForLoadBtn);//passes the listener from controller
    }
}

