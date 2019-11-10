package GameEntity.TowerType;

import GameField.GameField;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ListTower {
    List<Tower> listTowersToAttack=new ArrayList<>();
    List<Tower> listTowersInShop=new ArrayList<>();
    public static final int NORMAL = 993;
    public static final int MACHINE = 156;
    public static final int SNIPER = 206;
    int typeTower;
    public void add(int x_pos,int y_pos){
        if(typeTower==NORMAL){
            listTowersToAttack.add(new NormalTower(x_pos*32,y_pos*32));
        }
        else if (typeTower==MACHINE){
            listTowersToAttack.add(new MachineGunTower(x_pos*32,y_pos*32));
        }
        else {
            listTowersToAttack.add(new SniperTower(x_pos*32,y_pos*32));
        }
    }
    public void sellTower(int i){
        listTowersToAttack.remove(i);
    }
    public void createTower(Graphics g, GameField gameField){
        listTowersInShop.add(new NormalTower(32*26,32));
        listTowersInShop.add(new MachineGunTower(32*26,32*3) );
        listTowersInShop.add(new SniperTower(32*26,32*5));
        for (Tower t:listTowersInShop){
            t.draw(g,gameField);
        }
    }
    public void drawTower(Graphics g,GameField gameField){
        if (!listTowersToAttack.isEmpty()){
            for (Tower t:listTowersToAttack){
                t.draw(g,gameField);
            }
        }
    }
    public int numberTower(){
        return listTowersToAttack.size();
    }


    public int getTypeTower() {
        return typeTower;
    }

    public void setTypeTower(int typeTower) {
        this.typeTower = typeTower;
    }
}
