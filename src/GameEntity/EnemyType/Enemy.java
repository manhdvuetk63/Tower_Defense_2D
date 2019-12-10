package GameEntity.EnemyType;

import Game.GameField;
import GameEntity.Bullet.Bullet;
import GameEntity.GameEntity;
import Map.Road;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class Enemy extends GameEntity implements Comparable<Enemy> {
    int HP_const;
    int HP;
    int speed;
    int def;
    int coin;
    int stt;
    boolean bleed=false;
    ListEnemy enemy;
    public boolean isBleed() {
        return bleed;
    }

    public void setBleed(boolean bleed) {
        this.bleed = bleed;
    }
    public static final int RIGHT = 1;
    public static final int LEFT = 2;
    public static final int DOWN = 3;
    public static final int UP = 4;
    Road road = new Road();
    public int getHP() {
        return HP;
    }

    public int getHP_const() {
        return HP_const;
    }

    public void setHP_const(int HP_const) {
        this.HP_const = HP_const;
    }

    public void setHP() {
        this.HP = HP_const;
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
        this.HP_const = HP;
        this.speed = speed;
        this.def = def;
        this.coin = coin;
        this.HP=HP;
        this.width=32;
        this.height=32;
        setX_pos(road.getListPoint()[0].x);
        setY_pos(road.getListPoint()[0].y);
    }

    @Override
    public int compareTo(Enemy o) {
        int i = o.getX_pos();
        return String.valueOf(this.getX_pos()).compareTo(String.valueOf(o.getX_pos()));
    }

    public void move(){
        switch (stt){
            case RIGHT:
                setX_pos(getX_pos()+getSpeed());
                break;
            case LEFT:
                setX_pos(getX_pos()-getSpeed());
                break;
            case DOWN:
                setY_pos(getY_pos()+getSpeed());
                break;
            case UP:
                setY_pos(getY_pos()-getSpeed());
                break;
        }
    }
    public void updateStatus() {
        Point point = new Point(getX_pos(), getY_pos());

        if (point.equals(road.getListPoint()[1])){
            stt = DOWN;
            setRotationRequired(90);
        }
        else if (point.equals(road.getListPoint()[2])) {
            stt = RIGHT;
            setRotationRequired(0);
        }
        else if (point.equals(road.getListPoint()[3])){
            stt = UP;
            setRotationRequired(-90);
        }
        else if (point.equals(road.getListPoint()[4])){
            stt=RIGHT;
            setRotationRequired(0);
        }
        else if (point.equals(road.getListPoint()[5])) {
            setBleed(true);
        }
    }
    public void draw(Graphics2D g) {
        getPoint();
        getPoint();
        Toolkit t = Toolkit.getDefaultToolkit();
        Image img = t.getImage("res/img/" + this.getName_Entity());
        g.rotate(Math.toRadians(rotationRequired),getX_pos()+16,getY_pos()+16);
        g.drawImage(img, getX_pos(), getY_pos(),32,32,null);
        g.rotate(Math.toRadians(-rotationRequired),getX_pos()+16,getY_pos()+16);
        g.setColor(Color.green);
        int a=(int) (32*((double)getHP()/HP_const));
        g.fillRect(getX_pos(),getY_pos(), (int) (32*((double)getHP()/HP_const)),4);
        g.setColor(Color.red);
        g.fillRect(getX_pos()+a,getY_pos(),32-a,4);
        updateStatus();
        move();
    }
    public Shape collider() {
        return new Rectangle2D.Double(getX_pos()-8, getY_pos()-8, 48, 32);
    }
    public boolean injure(Bullet bullet) {
        if (collider().intersects((Rectangle2D) bullet.collider())) {
            HP = HP - bullet.getDamage();
            return true;
        }
        return false;
    }
}