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
    int[][] towerInMap;
    int number=1;
    public ListTower(){
        towerInMap=new int[17][31];
        for (int i=0; i<17;i++){
            for (int j=0;j<31;j++){
                towerInMap[i][j]=0;
            }
        }
    }
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
            towerInMap[y_pos][x_pos]=number++;
        } else hand = 0;
    }

    public void sellTower(int x_pos,int y_pos,User user) {
        if (towerInMap[y_pos][x_pos]!=0) {
            user.player.money +=listTowersToAttack.get(towerInMap[y_pos][x_pos]-1).cost/2;
            listTowersToAttack.remove(towerInMap[y_pos][x_pos]-1);
            for (int i=0;i<17;i++){
                for (int j=0;j<31;j++) {
                    if (towerInMap[i][j] > towerInMap[y_pos][x_pos]) {
                        towerInMap[y_pos][x_pos] = towerInMap[y_pos][x_pos] - 1;
                    }
                }
            }
            number--;
            towerInMap[y_pos][x_pos]=0;
            System.out.println(number);
        }
        hand=0;
    }

    public void createTower(GameField gameField) {


        listTowersInShop.add(new NormalTower(32 * 24, 32));
        listTowersInShop.add(new MachineGunTower(32 * 24, 32 * 3));
        listTowersInShop.add(new SniperTower(32 * 24, 32 * 5));
    }

    public void drawTower(Graphics2D g, GameField gameField) {
        Toolkit tk=Toolkit.getDefaultToolkit();
        Image image=tk.getImage("res/img/coin.png");
        Image image1=tk.getImage("res/img/damage.png");
        Image image2=tk.getImage("res/img/range.png");
        g.setColor(Color.yellow);
        g.setFont(new Font("NewellsHand", Font.PLAIN, 18));
        for (Tower t : listTowersInShop) {
            t.draw(g);
            g.drawString(String.valueOf(t.cost), t.getX_pos() + 48, t.getY_pos() + 16);
            g.drawImage(image,t.getX_pos()+64,t.getY_pos()+32,20,20,null);
            g.drawString(String.valueOf(t.range),t.getX_pos()+48+48,t.getY_pos()+16);
            g.drawImage(image2,t.getX_pos()+64+48,t.getY_pos()+32,20,20,null);
            g.drawString(String.valueOf(t.damege),t.getX_pos()+48+48+48,t.getY_pos()+16);
            g.drawImage(image1,t.getX_pos()+64+48+48,t.getY_pos()+32,20,20,null);
        }
        if (!listTowersToAttack.isEmpty()) {
            for (Tower t : listTowersToAttack) {
                t.draw(g);
                g.drawOval(t.getX_pos()+16-t.range/2,t.getY_pos()+16-t.range/2,t.range,t.range);
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