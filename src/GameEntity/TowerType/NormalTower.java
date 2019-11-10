package GameEntity.TowerType;

import GameField.GameField;

import java.awt.*;

public class NormalTower extends Tower {
    public NormalTower(int x,int y) {
        super(100,100,128,100);
        setName_Entity("NormalTower.png");
        setX_pos(x);
        setY_pos(y);
    }
}

