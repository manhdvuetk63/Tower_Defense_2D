package GameEntity.TowerType;

import GameField.GameField;

import java.awt.*;

public class SniperTower extends Tower {
    public SniperTower(int x,int y) {
        super(100,80,168,100);
        setName_Entity("Sniper.png");
        setX_pos(x);
        setY_pos(y);
    }

}
