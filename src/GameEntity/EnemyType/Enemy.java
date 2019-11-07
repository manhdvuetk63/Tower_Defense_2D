package GameEntity.EnemyType;

import GameEntity.GameEntity;
import Map.Road;

import java.awt.*;

public abstract class Enemy extends GameEntity implements Comparable<Enemy> {
    int HP;
    int speed;
    int def;
    int coin;
    int stt;
    public static final int RIGHT = 1;
    public static final int LEFT = 2;
    public static final int DOWN = 3;
    public static final int UP = 4;
    Road road = new Road();

    public Enemy() {
        setX_pos(road.getListPoint()[0].x);
        setY_pos(road.getListPoint()[0].y);
    }

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
        int i = o.getX_pos();
        return String.valueOf(this.getX_pos()).compareTo(String.valueOf(o.getX_pos()));
    }

    public abstract void move();

    public void updateStatus() {
        Point point = new Point(getX_pos(), getY_pos());
        if (point.equals(road.getListPoint()[1])) stt = DOWN;
        else if (point.equals(road.getListPoint()[2])) stt = RIGHT;
        else if (point.equals(road.getListPoint()[3])) stt = UP;
        else if (point.equals(road.getListPoint()[4])) stt=RIGHT;
        else if (point.equals(road.getListPoint()[5])) {
            setHP(0);
        }

    }
}
