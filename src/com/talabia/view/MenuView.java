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
        
//        saveBtn.addActionListener(e -> board.saveGame());
//
//        loadBtn.addActionListener(e -> {
//            JFileChooser fileChooser = new JFileChooser();
//            int returnValue = fileChooser.showOpenDialog(null);
//            if (returnValue == JFileChooser.APPROVE_OPTION) {
//                File selectedFile = fileChooser.getSelectedFile();
//                board.loadGame(selectedFile.getAbsolutePath());
//            }
//        });
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

