package GameEntity.Bullet;

import Game.GameField;
import GameEntity.GameEntity;
import GameEntity.TowerType.Tower;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class Bullet extends GameEntity {
    private double speed;
    private int damage;
    private int stt = 0;
    private Tower tower;
    private Shape enemy_pos;
    boolean aBoolean;

    public Bullet(double speed, int damage, int stt, Tower tower) {
        this.speed = speed;
        this.damage = damage;
        this.stt = stt;
        this.tower = tower;
        this.width = 32;
        this.height = 32;
        aBoolean=false;
        //setPoint();
    }

    public Shape getEnemy_pos() {
        return enemy_pos;
    }

    public void setEnemy_pos(Shape enemy_pos) {
        enemy_pos = enemy_pos;
    }

    public Tower getTower() {
        return tower;
    }

    public void setTower(Tower tower) {
        this.tower = tower;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public boolean destroy() {
        if (tower != null) {
            if (!tower.collider().intersects((Rectangle2D) this.collider())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void draw(Graphics2D g) {
        Toolkit t = Toolkit.getDefaultToolkit();
        Image image = t.getImage(name_Entity);
         g.rotate(rotationRequired,getPoint().x,getPoint().y);
        g.drawImage(image, getX_pos(), getY_pos(), 32, 32, null);
         g.rotate(-rotationRequired,getPoint().x,getPoint().y);
        move();
    }


    public void move() {
        switch (stt) {

            case 1:
                if(!aBoolean){
                    aBoolean=true;
                }
                setX_pos((int) (getX_pos() + 12 * Math.sin(Math.PI - rotationRequired)));
                setY_pos((int) (getY_pos() + 12 * Math.cos(Math.PI - rotationRequired)));
                break;
            case 2:
                if(!aBoolean){
                    aBoolean=true;
                }
                setX_pos((int) (getX_pos() + 12 * Math.sin(rotationRequired)));
                setY_pos((int) (getY_pos() - 12 * Math.cos(rotationRequired)));
                break;
            case 3:
                if(!aBoolean){
                    aBoolean=true;
                }
                setX_pos((int) (getX_pos() - 12 * Math.sin(rotationRequired - Math.PI)));
                setY_pos((int) (getY_pos() + 12 * Math.cos(rotationRequired - Math.PI)));
                break;
            case 4:
                if(!aBoolean){
                    aBoolean=true;
                }
                setX_pos((int) (getX_pos() - 12 * Math.sin(-rotationRequired)));
                setY_pos((int) (getY_pos() - 12 * Math.cos(-rotationRequired)));
                break;
            default:
        }
    }

    public Shape collider() {
        return new Rectangle2D.Double(getX_pos()+15, getY_pos()+15, 2, 2);
    }

    public void explosion(Graphics2D g,int x,int y){
        Toolkit t = Toolkit.getDefaultToolkit();
        Image img=t.getImage("res/img/explosion.gif");
        g.drawImage(img,x,y,48,48,null);
    }
}
