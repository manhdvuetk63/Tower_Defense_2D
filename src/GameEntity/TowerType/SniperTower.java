package GameEntity.TowerType;


import java.awt.*;

public class SniperTower extends Tower {
    public SniperTower(int x,int y) {
        super(100,80,168,10);
        setName_Entity("Sniper.png");
        setX_pos(x);
        setY_pos(y);
    }

}
