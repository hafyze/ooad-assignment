package view;

import controller.BoardController;

import javax.swing.*;
import java.awt.*;

public class BoardView extends JFrame {

    private static final int BOARD_SIZE = 8;
    private static final int SPOT_SIZE = 50;

    public BoardView(BoardController controller) {

        setTitle("Tilapia Chess");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);

        setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                JPanel cell = new JPanel();
                cell.setPreferredSize(new Dimension(SPOT_SIZE, SPOT_SIZE));
                cell.setBackground(controller.getCellColor(row, col));
                add(cell);
            }
        }

        setVisible(true);
    }
}
