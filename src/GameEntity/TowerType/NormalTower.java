package GameEntity.TowerType;


import GameEntity.Bullet.Bullet;
import GameEntity.Bullet.BulletMachine;

import java.awt.*;
import java.io.IOException;

public class NormalTower extends Tower {
    public NormalTower(int x,int y) {
        super(1000,100,128,200);
        setName_Entity("NormalTower.png");
        setX_pos(x);
        setY_pos(y);
    }


    @Override
    public void attackEnemy(Graphics2D g) {
        if (timeAttack--<=0){

            if (getxDistance() <= 0 && getyDistance() <= 0) {
                setStt(1);
            } else if (getxDistance() <= 0 && getyDistance() >= 0) {
                setStt(2);
            } else if (getxDistance() >= 0 && getyDistance() <= 0) {
                setStt(3);
            } else if (getxDistance() >= 0 && getyDistance() >= 0) {
                setStt(4);
            }

            Bullet b=new BulletMachine(speed,damege,stt,this);
            b.setX_pos(getX_pos());
            b.setY_pos(getY_pos());
            b.setRotationRequired(rotationRequired);
            b.setEnemy_pos(enemy_pos);
            bullet.add(b);
            setTimeAttack(10);
        }

    }
}


