package GameEntity.TowerType;

import GameField.GameField;

import java.awt.*;

public class MachineGunTower extends Tower {


    public MachineGunTower(int x,int y) {
        super(100,200,64,50);
        setName_Entity("Machine.png");
        setX_pos(x);
        setY_pos(y);
    }

}
