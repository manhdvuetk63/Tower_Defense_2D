package GameEntity.Bullet;

import GameEntity.TowerType.Tower;

public class BulletMachine extends Bullet {
    public BulletMachine(double speed, int damage, int stt, Tower tower) {
        super(speed, damage, stt, tower);
        this.name_Entity="res\\img\\bullet1.png";
    }
}
