package GameEntity;

public abstract  class GameTile extends GameEntity {
    int cost;
    int speed;
    int range;
    int damage;

    public GameTile(int cost, int speed, int range, int damage) {
        this.cost = cost;
        this.speed = speed;
        this.range = range;
        this.damage = damage;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
