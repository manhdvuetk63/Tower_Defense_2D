package GameEntity.EnemyType;

import Game.GameField;
import Player.User;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListEnemy {
    public List<Enemy> enemyList=new ArrayList<>();
    int timeBorn=1;
    int amount=200;
    int type_Ememy;
    public void addEnemy(Enemy enemy){
        enemyList.add(enemy);
    }
    public void sortList(){
        Collections.sort(enemyList);
    }
    public void delete(User user){
        for (int i=0;i<enemyList.size();i++){
            if(enemyList.get(i).getHP()<=0) {
                user.player.money+=enemyList.get(i).coin;
                enemyList.remove(i);
            }
            if (enemyList.get(i).isBleed()){
                user.player.health-=200;
                enemyList.remove(i);
            }
        }
    }
    public boolean isNewEnermy(){
        if(timeBorn--==0&&amount>0){
            timeBorn=100;
            amount--;
            return true;
        }
        return false;
    }

    public void Draw(Graphics2D g, GameField gameField) {

        for (Enemy enemy:this.enemyList){
            enemy.draw(g,gameField);
        }
    }
    public Enemy ramdomEnemy(){
        Random random=new Random();
        setType_Ememy(random.nextInt(4));
        if(getType_Ememy()==0) return new SmallerEnemy();
        else if(getType_Ememy()==1) return new NormalEnemy();
        else if (getType_Ememy()==2) return new BossEnemy();
        else if (getType_Ememy()==3) return new TankerEnemy();
        return null;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getTimeBorn() {
        return timeBorn;
    }

    public void setTimeBorn(int timeBorn) {
        this.timeBorn = timeBorn;
    }

    public void setType_Ememy(int type_Ememy) {
        this.type_Ememy = type_Ememy;
    }

    public int getType_Ememy() {
        return type_Ememy;
    }
}
