package PagesPackages.Games.Snake;

import javax.swing.JFrame;


public class GameFrame extends JFrame{

    public GameFrame() {

        this.add(new GamePanel());
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        //this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }
    
}