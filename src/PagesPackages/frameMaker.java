package PagesPackages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import JStyles.SButton;
import MainPackage.MainFrame;
import PagesPackages.Apps.Caculator.Calculator;

public class frameMaker extends Frame implements ActionListener {

    JFrame frame;
    JPanel containerPanel;
    SButton btnBack;
    // Apps buttons
    SButton btnCalculator;
    // SButton btnPaint;
    SButton btnPaint;
    // Games buttons
    SButton btnxoG;
    SButton btnHangManG;
    SButton btnSnakeG;

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
        }

        btnBack = new SButton("Go Back");
        btnBack.setFocusable(false);
        btnBack.setPreferredSize(new Dimension(400, 100));
        btnBack.addActionListener(this);
        containerPanel.add(btnBack);

        frame.add(copyRightPanel, BorderLayout.SOUTH);
        frame.add(containerPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void App() {

        btnCalculator = new SButton("Calculator App");
        btnPaint = new SButton("Paint App");

        btnCalculator.setFocusable(false);
        btnPaint.setFocusable(false);

        btnCalculator.setPreferredSize(new Dimension(400, 100));
        btnPaint.setPreferredSize(new Dimension(400, 100));

        btnCalculator.addActionListener(this);
        btnPaint.addActionListener(this);

        containerPanel.add(btnCalculator);
        containerPanel.add(btnPaint);
    }

    private void Game() {

        btnxoG = new SButton("Play Tic Tac Toe");
        btnHangManG = new SButton("Play Hangman");
        btnSnakeG = new SButton("Play Snack");

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
        } else if (e.getSource() == btnCalculator) {
            new Calculator();
        }
    }
}