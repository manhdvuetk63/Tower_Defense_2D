package State;

import Game.GameField;
import GameEntity.EnemyType.ListEnemy;
import GameEntity.TowerType.ListTower;
import Load_res.GameSound;
import Map.Map;
import Player.User;

import java.awt.*;
import java.awt.event.MouseEvent;

public class StateGame extends StatesOfGame {
    GameField gameField;
    ListEnemy listEnemy;
    ListTower listTower;

    int x_pos, y_pos;
    User user;
    Map mapgame;
    public boolean pause = false;

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public StateGame(GameField gameField, User user) {
        super(gameField);
        this.user = user;
        mapgame = new Map();
        listTower = new ListTower();
        listTower.createTower(gameField);
        listEnemy = new ListEnemy();
    }

    boolean mouseDown = false;

    public void mouseDown(java.awt.event.MouseEvent e) {
        mouseDown = true;
        if (listTower.hand != 0) {
            if (mapgame.HereCanBuild[y_pos][x_pos]) {
                listTower.add(x_pos, y_pos, user);
            }
        }
        listTower.hand = 0;
        mouseUpdate(e);
    }

    @Override
    public void loadMenu(Graphics2D g) {

    }

    public void loadGame(Graphics2D g) {
        mapgame.Draw(g, gameField);

        if (listTower.hand == 1) {
            mapgame.DrawRect(g);
        }
        listTower.drawTower(g, gameField);
        if (listEnemy.isNewEnermy()) {
            listEnemy.addEnemy(listEnemy.ramdomEnemy());
        }
        if (!listEnemy.enemyList.isEmpty()) {
            listEnemy.Draw(g, gameField);
            listEnemy.delete(user);
        }
        listTower.fire(listEnemy.enemyList, g);
        user.draw(g);
        String s = "WAVE :" + listEnemy.gameRound + "";
        g.drawString(s, 25 * 32, 32 * 8);
    }

    @Override
    public void draw(Graphics2D g) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    public void mouseUpdate(java.awt.event.MouseEvent e) {
        System.out.println(x_pos + " " + y_pos);
        if (mouseDown && listTower.hand == 0) {
            if (x_pos == 24 && y_pos == 1) {
                listTower.setTypeTower(ListTower.NORMAL);
                listTower.hand = 1;
            } else if (x_pos == 24 && y_pos == 3) {
                listTower.setTypeTower(ListTower.MACHINE);
                listTower.hand = 1;
            } else if (x_pos == 24 && y_pos == 5) {
                listTower.setTypeTower(ListTower.SNIPER);
                listTower.hand = 1;
            }
            if (x_pos == 25 && y_pos == 13 || (x_pos == 26 && y_pos == 13)) {
                pause = true;
            }
            GameSound.play(GameSound.tick);
        }
    }

    public void mouseMoved(java.awt.event.MouseEvent e) {
        x_pos = e.getX() / 32;
        y_pos = e.getY() / 32 - 1;
    }

}

