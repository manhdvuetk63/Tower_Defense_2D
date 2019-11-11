package GameEntity.TowerType;

import GameEntity.EnemyType.Enemy;
import GameEntity.GameEntity;
import GameField.GameField;

import javax.swing.*;
import javax.swing.text.Element;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageFilter;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public abstract class Tower extends GameEntity {
    int cost,speed,range,damege;
    boolean hasEnemy=false;
    public List<Bullet> listBullet=new ArrayList<>();
    public Tower(int cost, int speed, int range, int damege) {
        this.cost = cost;
        this.speed = speed;
        this.range = range;
        this.damege = damege;
    }

    @Override
    public void draw(Graphics2D g, GameField gameField) {
        super.getPoint();
        Toolkit t = Toolkit.getDefaultToolkit();
        Image img = t.getImage("res/img/" + this.getName_Entity());
        g.drawImage(img, getX_pos(), getY_pos(), gameField);
    }
}
