package GameEntity.TowerType;

import GameEntity.EnemyType.Enemy;
import GameField.GameField;
import Player.User;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ListTower {
    List<Tower> listTowersToAttack = new ArrayList<>();
    List<Tower> listTowersInShop = new ArrayList<>();
    public static final int NORMAL = 993;
    public static final int MACHINE = 156;
    public static final int SNIPER = 206;
    int typeTower;

    public void add(int x_pos, int y_pos, User user) {
        Tower t = null;
        if (typeTower == NORMAL) {
            t = new NormalTower(x_pos * 32, y_pos * 32);
        } else if (typeTower == MACHINE) {
            t = new MachineGunTower(x_pos * 32, y_pos * 32);
        } else if (typeTower == SNIPER) {
            t = new SniperTower(x_pos * 32, y_pos * 32);
        }
        if (user.player.money >= t.cost) {
            listTowersToAttack.add(t);
            user.player.money -= t.cost;
        }
    }
    public void sellTower(int i) {
        listTowersToAttack.remove(i);
    }

    public void createTower( GameField gameField) {


        listTowersInShop.add(new NormalTower(32 * 24, 32));
        listTowersInShop.add(new MachineGunTower(32 * 24, 32*2 ));
        listTowersInShop.add(new SniperTower(32 * 24, 32*3 ));
    }

    public void drawTower(Graphics2D g, GameField gameField) {
        g.setFont(new Font("NewellsHand",Font.PLAIN,18));
        for (Tower t : listTowersInShop) {
            t.draw(g,gameField);
            g.drawString(String.valueOf(t.cost),t.getX_pos()+48,t.getY_pos()+16);
        }
        if (!listTowersToAttack.isEmpty()) {
            for (Tower t : listTowersToAttack) {
                t.draw(g, gameField);
            }
        }
    }

    public void fire(List<Enemy> enemies, Graphics2D g) {
        if (!listTowersToAttack.isEmpty() && !enemies.isEmpty()) {
            for (Tower t : listTowersToAttack) {
                for (Enemy e : enemies) {
                    if (t.range(e.point) <= t.range / 2) {
                        g.drawLine(t.getX_pos() + 16, t.getY_pos() + 16, e.getX_pos() + 16, e.getY_pos() + 16);
                        e.setHP(e.getHP() - t.damege);
                        break;
                    }
                }
            }
        }
    }

    public int getTypeTower() {
        return typeTower;
    }

    public void setTypeTower(int typeTower) {
        this.typeTower = typeTower;
    }
}
