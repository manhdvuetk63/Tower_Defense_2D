package GameEntity.TowerType;

import java.util.ArrayList;
import java.util.List;

public class ListTower {
    List<Tower> listTowers=new ArrayList<>();
    public void add(int x_pos,int y_pos,Tower tower){
        tower.setX_pos(x_pos);
        tower.setY_pos(y_pos);
        listTowers.add(tower);
    }
    public void sellTower(int i){
        listTowers.remove(i);
    }
}
