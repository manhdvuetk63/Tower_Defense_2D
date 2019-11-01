package GameField;

import Controller.KeyHandler;
import GameStage.GameStage;
import Player.User;

import javax.swing.*;
import java.awt.*;

public class GameField extends JPanel implements Runnable {
    Thread thread = new Thread(this);
    GameStage gameStage;
    User user;
    boolean running = true;
    private int fps = 0;
    public int scene = 0;

    public GameField(GameStage gameStage) {
        this.gameStage = gameStage;
        this.gameStage.addKeyListener(new KeyHandler(this));
        this.thread.start();
    }

    @Override
    public void run() {
        System.out.println("Susses");
        long lastFrame = System.currentTimeMillis();
        int frames = 0;
        loadGame();
        while (running) {
            repaint();
            frames++;
            if (System.currentTimeMillis() - 1000 >= lastFrame) {
                fps = frames;
                frames = 0;
                lastFrame = System.currentTimeMillis();
            }
            try {
                Thread.sleep(frames);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }

    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, this.gameStage.getWidth(), this.gameStage.getHeight());
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, this.gameStage.getWidth(), this.gameStage.getHeight());
    }

    public void loadGame() {
        user=new User(this);
        running = true;
    }

    public void startGame() {
        user.createPlayer();
        this.scene=1;

    }

    public class KeyTyped {
        public void keyESC() {
            running = false;
        }

        public void keySpace() {
            startGame();
        }
    }

}
