package main;

import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame {
    public MainGUI() {
        setTitle("Tilapia Chess");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,400);

        Board chessBoard = new Board();
        add(chessBoard);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainGUI();
    }
}

class Board extends JPanel {
    private static final int BOARD_SIZE = 8;
    private static final int SPOT_SIZE = 50;

    public Board() {
        setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                JPanel cell = new JPanel();
                cell.setPreferredSize(new Dimension(SPOT_SIZE, SPOT_SIZE));

                if ((row + col) % 2 == 0) {
                    cell.setBackground(Color.WHITE);
                } else {
                    cell.setBackground(Color.BLACK);
                }
                add(cell);
            }
        }
    }
}