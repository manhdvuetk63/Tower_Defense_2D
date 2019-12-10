package GameEntity.Bullet;

import GameEntity.TowerType.Tower;

public class NormalBullet extends Bullet {
    public NormalBullet(double speed, int damage, int stt, Tower tower) {
        super(speed, damage, stt, tower);
        this.name_Entity="res\\img\\bullet2.png";
    }
}
