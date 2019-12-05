package GameEntity.TowerType;


import java.awt.*;

public class MachineGunTower extends Tower {


    public MachineGunTower(int x,int y) {
        super(1000,200,32*5,6);
        setName_Entity("Machine.png");
        setX_pos(x);
        setY_pos(y);
    }

}
