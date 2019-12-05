package Game;

import Controller.MouseEvent;
import Map.Map;
import Player.User;
import Load_res.GameSound;
import State.GameOver;
import State.StateGame;
import State.StateMenu;

import javax.swing.*;
import java.awt.*;

public class GameField extends JPanel implements Runnable {
    GameSound sound;
    Thread thread = new Thread(this);
    GameStage gameStage;
    User user;
    public StateMenu stateMenu;
    public StateGame stateGame;
    public GameOver gameOver;
    public boolean running = true;
    public int scene = 0;
    boolean hasSound = true;

    public GameField(GameStage gameStage) {
        this.sound = new GameSound();
        this.gameStage = gameStage;
        this.gameStage.addMouseListener(new MouseEvent(this));
        this.gameStage.addMouseMotionListener(new MouseEvent(this));
       // stateMenu = new StateMenu(this);

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
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }
    public void paintComponent(Graphics g2) {
        Graphics2D g = (Graphics2D) g2.create();
        g.clearRect(0, 0, this.gameStage.getWidth(), this.gameStage.getHeight());
        switch (scene) {
            case 0://menu
                if (hasSound == true) {
                    hasSound = false;
                    sound.play(sound.intro);
                    loadMenu();
                }
                stateMenu.loadMenu(g);
                break;
                case 1://gameState
                stateGame.loadGame(g);
                if (checkHPofPlayer()==true) {
                    scene=2;
                    stateGame=null;
                    user=null;
                    gameOver=new GameOver(this);
                }
                break;
            case 2://gameOver
                gameOver.draw(g);
                break;
            default:
        }
    }
    public void loadGame() {
        user = new User(this);
        running = true;
    }
    public void loadMenu(){
        stateMenu = new StateMenu(this);
    }
    public void loadOver(){
        gameOver=new GameOver(this);
    }
    public void startGame() {
        user.createPlayer();
        stateGame = new StateGame(this, user);
        this.scene = 1;
    }
    public boolean checkHPofPlayer(){
        if (user.player.health<=0) return true;
        return false;
    }
}
