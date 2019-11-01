package GameEntity.EnemyType;

import GameEntity.GameEntity;

public abstract class Enemy extends GameEntity implements Comparable<Enemy>{
    int HP;
    int speed;
    int def;
    int coin;
    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }


    public Enemy(int HP, int speed, int def, int coin) {
        this.HP = HP;
        this.speed = speed;
        this.def = def;
        this.coin = coin;
    }

    @Override
    public int compareTo(Enemy o) {
        int i=o.getX_pos();
        return  String.valueOf(this.getX_pos()).compareTo(String.valueOf(o.getX_pos()));
    }
    public abstract void move();
}
