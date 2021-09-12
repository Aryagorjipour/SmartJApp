package MainPackage;

import javax.swing.*;
import PagesPackages.frameMaker;
import java.awt.event.*;
import java.io.IOException;
import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;
import JStyles.*;

public class MainFrame implements ActionListener, MouseListener {

    SButton btnApps;
    SButton btnGames;
    JFrame frame = new JFrame();
    SButton btnAbout;

    public MainFrame() {

        frame.setTitle("SmartJ Entertainment|Tools");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));
        frame.setSize(800, 700);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setBackground(new Color(0xf7f8f9));

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel westPanel = new JPanel();
        JPanel eastPanel = new JPanel();

        topPanel.setPreferredSize(new Dimension(100, 100));
        westPanel.setPreferredSize(new Dimension(20, 100));
        eastPanel.setPreferredSize(new Dimension(20, 100));
        bottomPanel.setPreferredSize(new Dimension(100, 40));
        centerPanel.setPreferredSize(new Dimension(100, 100));

        bottomPanel.setBackground(new Color(0xc3c3c3));

        topPanel.setLayout(new BorderLayout(10, 10));

        JLabel welcomeLabel = new JLabel("Welcome to smartJ");
        JLabel copyrightLabel = new JLabel("© Copyright SmartAsGroup 2021. All Rights Reserved");

        welcomeLabel.setForeground(new Color(0x36393d));
        welcomeLabel.setFont(new Font("MV Boli", Font.BOLD, 30));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setVerticalAlignment(JLabel.CENTER);

        copyrightLabel.setForeground(new Color(0x36393d));
        copyrightLabel.setFont(new Font("MV Boli", Font.BOLD, 10));
        copyrightLabel.setHorizontalAlignment(JLabel.CENTER);
        copyrightLabel.setVerticalAlignment(JLabel.BOTTOM);

        topPanel.add(welcomeLabel, BorderLayout.CENTER);
        bottomPanel.add(copyrightLabel, BorderLayout.CENTER);

        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        btnApps = new SButton("Apps");
        btnGames = new SButton("Games");
        btnAbout = new SButton("About");

        
        btnApps.addMouseListener(this);
        btnApps.addActionListener(this);

       
        btnGames.addMouseListener(this);
        btnGames.addActionListener(this);

        
        btnAbout.addMouseListener(this);
        btnAbout.addActionListener(this);

        btnApps.setPreferredSize(new Dimension(700, 150));
        btnGames.setPreferredSize(new Dimension(700, 150));
        btnAbout.setPreferredSize(new Dimension(700, 150));

        centerPanel.add(btnApps);
        centerPanel.add(btnGames);
        centerPanel.add(btnAbout);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(westPanel, BorderLayout.WEST);
        frame.add(eastPanel, BorderLayout.EAST);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnApps) {
            frame.dispose();
            new frameMaker(500, 500, "App", "Choose app");
        } else if (e.getSource() == btnGames) {
            frame.dispose();
            new frameMaker(500, 550, "Game", "Which game do you want to play");
        } else if (e.getSource() == btnAbout) {
            try {
                Desktop.getDesktop().browse(new URI("https://github.com/Aryagorjipour/SmartJApp"));
            } catch (IOException | URISyntaxException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Nothing for now
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Nothing for now
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Nothing for now
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getComponent() == btnApps) {
            btnApps.setBackground(new Color(0xd97eb6));
            btnApps.setForeground(new Color(0xFFFFFF));
        } else if (e.getComponent() == btnGames) {
            btnGames.setBackground(new Color(0xd97eb6));
            btnGames.setForeground(new Color(0xFFFFFF));

        } else if (e.getComponent() == btnAbout) {
            btnAbout.setBackground(new Color(0xd97eb6));
            btnAbout.setForeground(new Color(0xFFFFFF));
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getComponent() == btnApps) {
            btnApps.setBackground(new Color(0xc133ff));
            btnApps.setForeground(new Color(0xFFFFFF));
        } else if (e.getComponent() == btnGames) {
            btnGames.setBackground(new Color(0xc133ff));
            btnGames.setForeground(new Color(0xFFFFFF));

        } else if (e.getComponent() == btnAbout) {
            btnAbout.setBackground(new Color(0xc133ff));
            btnAbout.setForeground(new Color(0xFFFFFF));
        }

    }
}
