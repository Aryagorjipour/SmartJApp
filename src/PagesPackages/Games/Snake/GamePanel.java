package PagesPackages.Games.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 75;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 6;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean isRunning = false;
    Timer timer;
    Random random;
    Color aColor;
    Color sColor;

    GamePanel() {
        random = new Random();
       
        sColor = new Color(0xff2589);
        
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        
        startGame();
    }

    public void startGame() {
        newApple();
        isRunning = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        
        if (isRunning) {
            // make Grid for see how much space each unit will get
            /*for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
                g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
            }*/

            aColor = new Color(random.nextInt(254),random.nextInt(254),random.nextInt(254));
        	g.setColor(aColor);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(sColor);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    g.setColor(sColor);
                    //g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));//random color for snack
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            g.setColor(new Color(0xc133ff));
            g.setFont(new Font("MV Boli",Font.PLAIN,40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2, g.getFont().getSize());
        }
        else{
            gameOver(g);
        }

    }

    public void newApple() {
        appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
        sColor = new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch (direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }
    }

    public void checkApple() {
        if ((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            newApple();
            sColor = aColor;
        }
    }

    public void checkCollisions() {
        // check if head collides with bodyParts
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                isRunning = false;
            }
        }
        // check if head touches left border
        if (x[0] < 0) {
            isRunning = false;
        }
        // check if head touches right border
        if (x[0] > SCREEN_WIDTH) {
            isRunning = false;
        }
        // check if head touches top border
        if (y[0] < 0) {
            isRunning = false;
        }
        // check if head touches bottom border
        if (y[0] > SCREEN_HEIGHT) {
            isRunning = false;
        }

        if (!isRunning) {
            timer.stop();
        }
    }

    public void gameOver(Graphics g) {
        //Game Over Text
    	g.setColor(new Color(0xc133ff));
        g.setFont(new Font("MV Boli",Font.BOLD,75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics.stringWidth("Game Over")) / 2, SCREEN_HEIGHT/2);
        
        g.setColor(new Color(0xc133ff));
        g.setFont(new Font("MV Boli",Font.PLAIN,40));
        FontMetrics metricsScore = getFontMetrics(g.getFont());
        g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metricsScore.stringWidth("Score: " + applesEaten)) / 2, g.getFont().getSize());
   
        g.setColor(Color.WHITE);
        g.setFont(new Font("MV Boli",Font.PLAIN,12));
        FontMetrics metricsCopy = getFontMetrics(g.getFont());
        g.drawString("© Copyright SmartAsGroup 2021. All Rights Reserved", (SCREEN_WIDTH - metricsCopy.stringWidth("© Copyright SmartAsGroup 2021. All Rights Reserved")) / 2, SCREEN_HEIGHT -  (g.getFont().getSize() * 2));
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("MV Boli",Font.PLAIN,12));
        FontMetrics metricsDeveloper = getFontMetrics(g.getFont());
        g.drawString("Developed by Arya Gorjipour", (SCREEN_WIDTH - metricsDeveloper.stringWidth("Developed by Arya Gorjipour")) / 2, SCREEN_HEIGHT -  2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isRunning) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }
        }
    }
}
