package GameEntity.EnemyType;

import GameField.GameField;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListEnemy {
    public List<Enemy> enemyList=new ArrayList<>();
    int timeBorn=1;
    int amount=20;
    public void addEnemy(Enemy enemy){
        enemyList.add(enemy);
    }
    public void sortList(){
        Collections.sort(enemyList);
    }
    public void delete(){
        for (int i=0;i<enemyList.size();i++){
            if(enemyList.get(i).getHP()<=0)  enemyList.remove(i);
        }
    }
    public boolean isNewEnermy(){
        if(timeBorn--==0&&amount>0){
            timeBorn=120;
            amount--;
            return true;
        }
        return false;
    }

    public void Draw(Graphics g, GameField gameField) {
        for (Enemy enemy:this.enemyList){
            enemy.draw(g,gameField);
        }
    }
}
