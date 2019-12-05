package GameEntity.TowerType;


import java.awt.*;

public class NormalTower extends Tower {
    public NormalTower(int x,int y) {
        super(1000,100,128,20);
        setName_Entity("NormalTower.png");
        setX_pos(x);
        setY_pos(y);
    }
}

