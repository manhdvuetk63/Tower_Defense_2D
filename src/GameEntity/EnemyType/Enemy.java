package GameEntity.EnemyType;

import GameEntity.GameEntity;
import GameField.GameField;
import Map.Road;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class Enemy extends GameEntity implements Comparable<Enemy> {
    int HP;
    int speed;
    int def;
    int coin;
    int stt;
    double rotationRequired=0;

    public double getRotationRequired() {
        return rotationRequired;
    }

    public void setRotationRequired(double rotationRequired) {
        this.rotationRequired = rotationRequired;
    }

    public static final int RIGHT = 1;
    public static final int LEFT = 2;
    public static final int DOWN = 3;
    public static final int UP = 4;
    Road road = new Road();
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

        if (point.equals(road.getListPoint()[1])) stt = DOWN;
        else if (point.equals(road.getListPoint()[2])) stt = RIGHT;
        else if (point.equals(road.getListPoint()[3])) stt = UP;
        else if (point.equals(road.getListPoint()[4])) stt=RIGHT;
        else if (point.equals(road.getListPoint()[5])) {
            setHP(0);
        }
//        if(stt==RIGHT){
//            if(getX_pos()<=road.getListPoint()[1].getX()&& getX_pos()>=road.getListPoint()[1].getX()-64){
//                setRotationRequired(rotationRequired++);
//                if (rotationRequired>=90) rotationRequired=90;
//                System.out.println(rotationRequired);
//            }
//        }

    }
    public void draw(Graphics2D g, GameField gameField) {
        getPoint();
        getPoint();
        Toolkit t = Toolkit.getDefaultToolkit();
        Image img = t.getImage("res/img/" + this.getName_Entity());
        g.drawImage(img, getX_pos(), getY_pos(), gameField);
        g.drawString(String.valueOf(HP),getX_pos(),getY_pos());
        updateStatus();
        move();
    }
}