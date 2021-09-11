package PagesPackages;

import MainPackage.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class frameMaker extends Frame implements ActionListener {

    JFrame frame;
    JPanel containerPanel;
    JButton btnBack;
    // Apps buttons
    JButton btnCalculator;
    JButton btnPaint;
    // Games buttons
    JButton btnxoG;
    JButton btnHangManG;
    JButton btnSnakeG;

    public frameMaker(int width, int height, String frameType, String title) {
        frame = new JFrame();
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setBackground(new Color(0xf7f8f9));
        frame.setLocationRelativeTo(null);

        containerPanel = new JPanel();
        JPanel copyRightPanel = new JPanel();

        containerPanel.setPreferredSize(new Dimension(400, 500));
        copyRightPanel.setPreferredSize(new Dimension(500, 40));

        JLabel copyrightLabel = new JLabel("© Copyright SmartAsGroup 2021. All Rights Reserved");

        copyrightLabel.setForeground(new Color(0x36393d));
        copyrightLabel.setFont(new Font("MV Boli", Font.BOLD, 10));
        copyrightLabel.setHorizontalAlignment(JLabel.CENTER);
        copyrightLabel.setVerticalAlignment(JLabel.BOTTOM);

        copyRightPanel.add(copyrightLabel, BorderLayout.CENTER);


        if (frameType == "App") {
            App();
        } else if (frameType == "Game") {
            Game();
        } else if (frameType == "About") {
            About();
        }

        btnBack = new JButton("Go Back");
        btnBack.setFocusable(false);
        btnBack.setPreferredSize(new Dimension(400, 100));
        btnBack.addActionListener(this);
        containerPanel.add(btnBack);

        frame.add(copyRightPanel, BorderLayout.SOUTH);
        frame.add(containerPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void About() {
        JLabel 
    }

    private void App() {

        btnCalculator = new JButton("Calculator App");
        btnPaint = new JButton("Paint App");
        
        btnCalculator.setFocusable(false);
        btnPaint.setFocusable(false);
        
        btnCalculator.setPreferredSize(new Dimension(400, 100));
        btnPaint.setPreferredSize(new Dimension(400, 100));
        
        containerPanel.add(btnCalculator);
        containerPanel.add(btnPaint);
    }

    private void Game() {

        btnxoG = new JButton("Play Tic Tac Toe");
        btnHangManG = new JButton("Play Hangman");
        btnSnakeG = new JButton("Play Snack");

        btnxoG.setFocusable(false);
        btnHangManG.setFocusable(false);
        btnSnakeG.setFocusable(false);

        btnxoG.setPreferredSize(new Dimension(400, 100));
        btnHangManG.setPreferredSize(new Dimension(400, 100));
        btnSnakeG.setPreferredSize(new Dimension(400, 100));

        containerPanel.add(btnxoG);
        containerPanel.add(btnHangManG);
        containerPanel.add(btnSnakeG);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            frame.dispose();
            new MainFrame();
        }
    }
}