package GameField;

import Controller.KeyHandler;
import GameEntity.Map;
import GameStage.GameStage;
import Player.User;

import javax.swing.*;
import java.awt.*;

public class GameField extends JPanel implements Runnable {
    Thread thread = new Thread(this);
    GameStage gameStage;
    User user;
    Map mapgame;
    boolean running = true;
    private int fps = 0;
    public int scene = 0;
    int a=0;

    public GameField(GameStage gameStage) {
        this.gameStage = gameStage;
        this.gameStage.addKeyListener(new KeyHandler(this));
        mapgame =new Map();
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
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }

    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, this.gameStage.getWidth(), this.gameStage.getHeight());

        System.out.println(a);
        switch (scene) {
            case 0:
                g.setColor(Color.BLUE);
                g.fillRect(0, 0, this.gameStage.getWidth(), this.gameStage.getHeight());
                break;
            case 1:
                g.fillRect(0, 0, this.gameStage.getWidth(), this.gameStage.getHeight());
                mapgame.Draw(g,this);
                break;
            default:

        }

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
