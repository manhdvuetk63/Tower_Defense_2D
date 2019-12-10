package Game;

import Controller.MouseEvent;
import Player.User;
import Load_res.GameSound;
import State.*;

import javax.swing.*;
import java.awt.*;

public class GameField extends JPanel implements Runnable {
    Thread thread = new Thread(this);
    GameStage gameStage;
    User user;
    public int timePlay = 200;
    public StateMenu stateMenu;
    public StateGame stateGame;
    public GameOver gameOver;
    public PauseState pauseGame;
    public boolean running = true;
    public int scene = 0;
    public boolean hasSound = true;

    public GameField(GameStage gameStage) {
        this.gameStage = gameStage;
        this.gameStage.addMouseListener(new MouseEvent(this));
        this.gameStage.addMouseMotionListener(new MouseEvent(this));
        stateMenu = new StateMenu(this);
        pauseGame = new PauseState(this);
        this.thread.start();
    }

    @Override
    public void run() {
        loadGame();
        while (running) {
            repaint();
            try {
                Thread.sleep(25);
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
                stateMenu.loadMenu(g);
                stateMenu.playSFX();
                break;
            case 1://gameState
                stateGame.playSFX();
                stateGame.loadGame(g);
                if (stateGame.pause) {
                    scene = 3;
                    stateGame.setPause(false);
                    timePlay = 2;
                }
                if (checkHPofPlayer() == true) {
                    scene = 2;
                    stateGame = null;
                    user = null;
                    loadOver();
                }
                break;
            case 2:
                //game over
                gameOver.playSFX();
                gameOver.draw(g);
                break;
            case 3:
                pauseGame.playSFX();
                pauseGame.draw(g);
                break;
            default:
        }
    }

    public void loadGame() {
        user = new User(this);
        running = true;
    }

    public void loadMenu() {

        stateMenu = new StateMenu(this);
    }

    public void loadOver() {

        gameOver = new GameOver(this);
    }

    public void startGame() {
        stateGame=null;
        user.createPlayer();
        stateGame = new StateGame(this, user);
        this.scene = 1;
    }

    public boolean checkHPofPlayer() {
        if (user.player.health <= 0) return true;
        return false;
    }
}
