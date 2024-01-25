package com.talabia.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MenuView extends JPanel {
    private JButton newBtn;
    private JButton saveBtn;
    private JButton loadBtn;

    public MenuView(){
        newBtn = new JButton("New");
        saveBtn = new JButton("Save");
        loadBtn = new JButton("Load");

        add(newBtn);
        add(saveBtn);
        add(loadBtn);
    }

    public void addNewBoardListener(ActionListener listenerForNewBtn){
        newBtn.addActionListener(listenerForNewBtn);
    }

    public void addSaveBoardListener(ActionListener listenerForSaveBtn){
        saveBtn.addActionListener(listenerForSaveBtn);
    }

    public void addLoadBoardListener(ActionListener listenerForLoadBtn){
        loadBtn.addActionListener(listenerForLoadBtn);
    }
}

