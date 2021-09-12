package Test;

import javax.swing.*;
import java.awt.*;

class Main {
    public static void main(String[] args) {
        // LayeredPane = Swing container that provides a
        // third dimension for positioning components
        // ex. depth, Z-index

        JLabel label1 = new JLabel();
        label1.setOpaque(true);
        label1.setBackground(Color.RED);
        label1.setBounds(50, 50, 200, 200);

        JLabel label2 = new JLabel("Welcome");
        label2.setOpaque(true);
        label2.setBackground(Color.GREEN);
        label2.setBounds(100, 100, 200, 200);

        JLabel label3= new JLabel();
        label3.setOpaque(true);
        label3.setBackground(Color.BLUE);
        label3.setBounds(150, 150, 200, 200);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 500, 500);
        layeredPane.add(label1, Integer.valueOf(0));//Instead  of using JLayeredPane.DEFAULT_LAYER
        layeredPane.add(label2, Integer.valueOf(2));//Instead  of using JLayeredPane.DRAG_LAYER
        layeredPane.add(label3, Integer.valueOf(1));//We can use Z-index like this

        JFrame frame = new JFrame();
        frame.add(layeredPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 500));
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
