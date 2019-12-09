package GameEntity.TowerType;

import Game.GameField;
import GameEntity.EnemyType.Enemy;
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
    public int hand = 0;

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
        } else hand = 0;
    }

    public void sellTower(int i) {
        listTowersToAttack.remove(i);
    }

    public void createTower(GameField gameField) {


        listTowersInShop.add(new NormalTower(32 * 24, 32));
        listTowersInShop.add(new MachineGunTower(32 * 24, 32 * 3));
        listTowersInShop.add(new SniperTower(32 * 24, 32 * 5));
    }

    public void drawTower(Graphics2D g, GameField gameField) {
        g.setColor(Color.yellow);
        g.setFont(new Font("NewellsHand", Font.PLAIN, 18));
        for (Tower t : listTowersInShop) {
            t.draw(g);
            g.drawString(String.valueOf(t.cost), t.getX_pos() + 48, t.getY_pos() + 16);
        }
        if (!listTowersToAttack.isEmpty()) {
            for (Tower t : listTowersToAttack) {
                t.draw(g);
            }
        }
    }

    public void fire(List<Enemy> enemies, Graphics2D g) {
        if (!listTowersToAttack.isEmpty() && !enemies.isEmpty()) {
            for (Tower t : listTowersToAttack) {
                if (t.checkInvasion((ArrayList<Enemy>) enemies)) {
                    t.attackEnemy(g);
                }
            }
            for (Enemy e:enemies){
                for (Tower t:listTowersToAttack){
                    for (int i=0;i<t.bullet.size();i++){
                        if (e.injure(t.bullet.get(i))) {
                            t.bullet.get(i).explosion(g,e.getX_pos(),e.getY_pos());
                            t.bullet.remove(i);

                        }
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