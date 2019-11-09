package GameEntity.TowerType;

import GameField.GameField;

import java.awt.*;

public class NormalTower extends Tower {
    public NormalTower() {
        super(100,100,128,100);
        setName_Entity("NormalTower.png");
        setX_pos(32*25);
        setY_pos(32);
    }
}

