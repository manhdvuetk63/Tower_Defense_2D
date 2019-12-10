package GameEntity.EnemyType;

import Game.GameField;
import Load_res.GameSound;
import Player.User;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

public class ListEnemy {
    public List<Enemy> enemyList=new ArrayList<>();
    int timeBorn=10;
    int count=0;
    int type_Ememy;
    int[] wave;
    public int gameRound=1;
    int getCount=1;
    int getGetCount=0;
    boolean nextWave=false;
    boolean endGame=false;
    public ListEnemy(){
        wave=new int[10000];
        File file=new File("res/datagame/wave.txt");
        try {
            Scanner sc=new Scanner(file);
            for (int i=0;i<1000;i++){
                wave[i]= Integer.parseInt(sc.next());
                if (wave[i]==10) break;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void addEnemy(Enemy enemy){
        enemyList.add(enemy);
    }
    public void sortList(){
        Collections.sort(enemyList);
    }
    public void delete(User user){
        if (!enemyList.isEmpty()) {
            for (int i = 0; i < enemyList.size(); i++) {
                if (enemyList.get(i).getHP() <= 0) {
                    user.player.money += enemyList.get(i).coin;
                    getCount++;
                    enemyList.remove(i);
                    GameSound.play(GameSound.enemyDie);
                }
            }
        }
        if (!enemyList.isEmpty()) {
            for (int i = 0; i < enemyList.size(); i++) {
                if (enemyList.get(i).isBleed()) {
                    user.player.health -= 200;
                    getCount++;
                    enemyList.remove(i);
                    GameSound.play(GameSound.over);
                }
            }
        }
    }
    public boolean isNewEnermy(){
        if(timeBorn--==0){
            timeBorn=70;
            return true;
        }
        return false;
    }

    public void Draw(Graphics2D g, GameField gameField) {
        if (getGetCount==getCount&&nextWave){
            gameRound++;
            nextWave=false;
        }
        for (Enemy enemy:this.enemyList){

            enemy.draw(g);
        }
    }
    public  Enemy ramdomEnemy(){
        setType_Ememy(wave[count++]);
        if(getType_Ememy()==0) return new SmallerEnemy();
        else if(getType_Ememy()==1) return new NormalEnemy();
        else if (getType_Ememy()==2) return new BossEnemy();
        else if (getType_Ememy()==3) return new TankerEnemy();
        else if (getType_Ememy()==5) {
            getGetCount=count;
            nextWave=true;
            setTimeBorn(1000);
            return new NormalEnemy();
        }
        else if (getType_Ememy()==10){
            endGame=true;
            return new BossEnemy();
        }
        return null;
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
