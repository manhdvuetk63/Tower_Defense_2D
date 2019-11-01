package GameEntity.EnemyType;

import java.util.ArrayList;
import java.util.Collections;

public class ListEnemy {
    public ArrayList<Enemy> enemyList=new ArrayList<>();
    public void addEnemy(Enemy enemy){
        enemyList.add(enemy);
    }
    public void sortList(){
        Collections.sort(enemyList);
    }
    public void delete(){
        for (int i=0;i<enemyList.size();i++){
            if(enemyList.get(i).getHP()<0)  enemyList.remove(i);
        }
    }

}
