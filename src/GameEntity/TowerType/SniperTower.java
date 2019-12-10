package GameEntity.TowerType;


import GameEntity.Bullet.Bullet;
import GameEntity.Bullet.BulletMachine;
import GameEntity.Bullet.SnipperBullet;
import Load_res.GameSound;

import java.awt.*;

public class SniperTower extends Tower {
    public SniperTower(int x,int y) {
        super(1500,80,300,3000);
        setName_Entity("Sniper.png");
        setX_pos(x);
        setY_pos(y);
        setTimeAttack(0);
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

            Bullet b=new SnipperBullet(speed,damege,stt,this);
            b.setX_pos(getX_pos());
            b.setY_pos(getY_pos());
            b.setRotationRequired(rotationRequired);
            b.setEnemy_pos(enemy_pos);
            b.setTower(this);
            bullet.add(b);
            setTimeAttack(80);
            GameSound.play(GameSound.fire3);
        }

    }
}

