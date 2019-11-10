package GameField;

import Controller.KeyHandler;

import Controller.MouseEvent;
import GameEntity.EnemyType.Enemy;
import GameEntity.EnemyType.ListEnemy;
import GameEntity.EnemyType.SmallerEnemy;
import GameEntity.TowerType.ListTower;
import GameEntity.TowerType.NormalTower;
import GameStage.GameStage;
import Map.Map;
import Map.Road;
import Player.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GameField extends JPanel implements Runnable {
    Thread thread = new Thread(this);
    GameStage gameStage;
    User user;
    Map mapgame;
    Road road;
    ListEnemy listEnemy;
    ListTower listTower;
    public boolean running = true;
    private int fps = 0;
    public int scene = 0;
    int hand = 0;
    int x_pos, y_pos;

    public GameField(GameStage gameStage) {
        this.gameStage = gameStage;
        this.gameStage.addKeyListener(new KeyHandler(this));
        this.gameStage.addMouseListener(new MouseEvent(this));
        this.gameStage.addMouseMotionListener(new MouseEvent(this));
        mapgame = new Map();
        road = new Road();
        listTower = new ListTower();
        listEnemy = new ListEnemy();
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
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }

    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, this.gameStage.getWidth(), this.gameStage.getHeight());
        switch (scene) {
            case 0:
                g.setColor(Color.BLUE);
                g.fillRect(0, 0, this.gameStage.getWidth(), this.gameStage.getHeight());
                break;
            case 1:
                g.fillRect(0, 0, this.gameStage.getWidth(), this.gameStage.getHeight());
                mapgame.Draw(g, this);
                listTower.createTower(g, this);
                listTower.drawTower(g, this);
                if (listEnemy.isNewEnermy()) {
                    listEnemy.addEnemy(listEnemy.ramdomEnemy());
                }
                if (!listEnemy.enemyList.isEmpty()) {
                    listEnemy.Draw(g, this);
                    listEnemy.delete();
                }
                break;
            default:

        }

    }

    public void loadGame() {
        user = new User(this);
        running = true;
    }

    public void startGame() {
        user.createPlayer();
        this.scene = 1;

    }

    public class KeyTyped {
        public void keyESC() {
            running = false;
        }

        public void keySpace() {
            startGame();
        }
    }

    public class MouseType {
        boolean mouseDown = false;

        public void mouseDown(java.awt.event.MouseEvent e) {
            mouseDown=true;
            if(hand!=0){
                if (mapgame.HereCanBuild[y_pos][x_pos]) {
                    listTower.add(x_pos, y_pos);
                }
                hand=0;
            }
            mouseUpdate(e);


        }
        public void mouseUpdate(java.awt.event.MouseEvent e){
            System.out.println(x_pos+" "+y_pos);

            if (scene == 1) {
                if (mouseDown&& hand == 0) {
                    if (x_pos == 26 && y_pos == 1) {
                        listTower.setTypeTower(ListTower.NORMAL);
                        System.out.println("ok1");
                        hand=1;
                    } else if (x_pos == 26 && y_pos == 3) {
                        listTower.setTypeTower(ListTower.MACHINE);
                        System.out.println("ok2");
                        hand=1;
                    } else if (x_pos == 26 && y_pos == 5) {
                        listTower.setTypeTower(ListTower.SNIPER);
                        System.out.println("ok3");
                        hand=1;
                    }
                }
            }
        }

        public void mouseMoved(java.awt.event.MouseEvent e) {
            x_pos = e.getX ()/ 32;
            y_pos = e.getY() / 32 - 1;
        }

    }

}
