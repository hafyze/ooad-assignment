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

    public void addNewGameListener(ActionListener listenerForNewBtn){
        newBtn.addActionListener(listenerForNewBtn);
    }

    public void addSaveGameListener(ActionListener listenerForSaveBtn){
        saveBtn.addActionListener(listenerForSaveBtn);
    }

    public void addLoadGameListener(ActionListener listenerForLoadBtn){
        loadBtn.addActionListener(listenerForLoadBtn);
    }
}