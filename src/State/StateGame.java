package State;

import Game.GameField;
import GameEntity.EnemyType.ListEnemy;
import GameEntity.TowerType.ListTower;
import Map.Map;
import Player.User;

import java.awt.*;
public class StateGame extends StatesOfGame {
    GameField gameField;
    ListEnemy listEnemy;
    ListTower listTower;

    int x_pos, y_pos;
    User user;
    Map mapgame;

    public StateGame(GameField gameField,User user) {
        super(gameField);
        this.user=user;
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
    public void loadGame(Graphics2D g){
        mapgame.Draw(g, gameField);
        if (listTower.hand==1) {
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
        g.drawString(user.toString(), 32 * 25, 32 * 10);
    }
    public void mouseUpdate(java.awt.event.MouseEvent e) {
        System.out.println(x_pos + " " + y_pos);
            if (mouseDown && listTower.hand == 0) {
                if (x_pos == 24 && y_pos == 1) {
                    listTower.setTypeTower(ListTower.NORMAL);
                    listTower.hand = 1;
                } else if (x_pos == 24 && y_pos == 2) {
                    listTower.setTypeTower(ListTower.MACHINE);
                    listTower.hand = 1;
                } else if (x_pos == 24 && y_pos == 3) {
                    listTower.setTypeTower(ListTower.SNIPER);
                    listTower.hand = 1;
                }

            }
        }


    public void mouseMoved(java.awt.event.MouseEvent e) {
        x_pos = e.getX() / 32;
        y_pos = e.getY() / 32 - 1;
    }

}
