package GameEntity.TowerType;

import Game.GameField;
import GameEntity.Bullet.Bullet;
import GameEntity.EnemyType.Enemy;
import GameEntity.GameEntity;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public abstract class Tower extends GameEntity {
    int cost, speed, range, damege;
    double rotationRequired = 0;
    Shape enemy_pos;

    int timeAttack;
    List<Bullet> bullet = new ArrayList<>();
    int stt;

    public Tower(int cost, int speed, int range, int damege) {
        this.cost = cost;
        this.speed = speed;
        this.range = range;
        this.damege = damege;
        this.width = 32;
        this.height = 32;
    }

    public int getTimeAttack() {
        return timeAttack;
    }

    public void setTimeAttack(int timeAttack) {
        this.timeAttack = timeAttack;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public double getxDistance() {
        return xDistance;
    }

    public void setxDistance(double xDistance) {
        this.xDistance = xDistance;
    }

    public double getyDistance() {
        return yDistance;
    }

    public void setyDistance(double yDistance) {
        this.yDistance = yDistance;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public void draw(Graphics2D g) {
        getPoint();
        Toolkit t = Toolkit.getDefaultToolkit();

        Image img = t.getImage("res/img/" + this.getName_Entity());
        Image image=t.getImage("res/img/underTower.png");
        g.drawImage(image,getX_pos()-8,getY_pos()-8,48,48,null);
        g.rotate(rotationRequired, getPoint().x, getPoint().y);
        g.drawImage(img, getX_pos(), getY_pos(), null);
        g.rotate(-rotationRequired, getPoint().x, getPoint().y);
        if (!bullet.isEmpty()) {
            for (Bullet b : bullet) {
                b.draw(g);
        }
        }
        if (!bullet.isEmpty()) {
            for (int i=0;i<bullet.size();i++) {
                if (bullet.get(i).destroy()) bullet.remove(i);
            }
        }
    }



    public boolean checkInvasion(ArrayList<Enemy> enemies) {
        for (Enemy e : enemies) {
            if (collider().intersects((Rectangle2D) e.collider())) {
                xDistance = (double) -e.getPoint().x + this.getPoint().x;
                yDistance = (double) -e.getPoint().y + this.getPoint().y;
                if (xDistance>0&&yDistance>0) {
                    this.rotationRequired = -Math.atan(Math.abs(xDistance / yDistance));
                }
                else if (xDistance >= 0 && yDistance <= 0) {
                    this.rotationRequired = +Math.atan(Math.abs(xDistance / yDistance))+Math.PI;
                }
                else if (xDistance < 0 && yDistance < 0){
                    this.rotationRequired = -Math.atan(Math.abs(xDistance / yDistance))+Math.PI;
                }
                else {
                    this.rotationRequired = +Math.atan(Math.abs(xDistance / yDistance));
                }
                enemy_pos=e.collider();
                return true;
            }
        }
        return false;
    }

    public Shape collider() {
        return new Ellipse2D.Double(getX_pos() - getRange() / 2 + getWidth() / 2, getY_pos() - getRange() / 2 + getHeight() / 2, getRange(), getRange());
    }

    public abstract void attackEnemy(Graphics2D g);

}
