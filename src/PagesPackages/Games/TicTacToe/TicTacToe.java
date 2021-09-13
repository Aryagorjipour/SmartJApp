package PagesPackages.Games.TicTacToe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import JStyles.*;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel botton_panel = new JPanel();
    JLabel textField = new JLabel();
    SButton[] buttons = new SButton[9];
    boolean playerOne_turn;
    //private int _turnCount = 0;

    public TicTacToe() throws InterruptedException {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 500);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Helvetica", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 500, 100);

        botton_panel.setLayout(new GridLayout(3, 3));
        botton_panel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new SButton();
            botton_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            
        }

        title_panel.add(textField);

        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(botton_panel);

        frame.setVisible(true);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (playerOne_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        playerOne_turn = false;
                        textField.setText("O turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 255, 0));
                        buttons[i].setText("O");
                        playerOne_turn = true;
                        textField.setText("X turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() throws InterruptedException {

        Thread.sleep(2000);

        if (random.nextInt(2) == 0) {
            playerOne_turn = true;
            textField.setText("X turn");
        } else {
            playerOne_turn = false;
            textField.setText("O turn");
        }
    }

    public void check() {
        // check X win conditions

        if ((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X")) {
            xWins(0, 1, 2);
        }
        if ((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X")) {
            xWins(3, 4, 5);
        }
        if ((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X")) {
            xWins(6, 7, 8);
        }
        if ((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X")) {
            xWins(0, 3, 6);
        }
        if ((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X")) {
            xWins(1, 4, 7);
        }
        if ((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X")) {
            xWins(2, 5, 8);
        }
        if ((buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X")) {
            xWins(0, 4, 8);
        }
        if ((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X")) {
            xWins(2, 4, 6);
        }

        // check O win conditions

        if ((buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O")) {
            oWins(0, 1, 2);
        }
        if ((buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O")) {
            oWins(3, 4, 5);
        }
        if ((buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O")) {
            oWins(6, 7, 8);
        }
        if ((buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O")) {
            oWins(0, 3, 6);
        }
        if ((buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O")) {
            oWins(1, 4, 7);
        }
        if ((buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O")) {
            oWins(2, 5, 8);
        }
        if ((buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O")) {
            oWins(0, 4, 8);
        }
        if ((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O")) {
            oWins(2, 4, 6);
        }

    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }

        textField.setText("X Wins");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.RED);
        buttons[b].setBackground(Color.RED);
        buttons[c].setBackground(Color.RED);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("O Wins");
    }

    public void draw() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("Draw");
    }
}