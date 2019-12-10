package GameEntity.Bullet;

import GameEntity.TowerType.Tower;

public class SnipperBullet extends Bullet
{
    public SnipperBullet(double speed, int damage, int stt, Tower tower) {
        super(speed, damage, stt, tower);
        this.name_Entity="res\\img\\bullet3.png";
    }
}
