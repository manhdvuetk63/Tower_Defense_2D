package GameEntity.TowerType;

import GameEntity.GameTile;

public abstract class Tower extends GameTile {

    public Tower(int cost, int speed, int range, int damage) {
        super(cost, speed, range, damage);
    }
}
