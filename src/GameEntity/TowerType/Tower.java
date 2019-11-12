package GameEntity.TowerType;

import GameEntity.EnemyType.Enemy;
import GameEntity.GameEntity;
import GameField.GameField;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.Element;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Tower extends GameEntity {
    int cost,speed,range,damege;
    double rotationRequired=0;
    public Tower(int cost, int speed, int range, int damege) {
        this.cost = cost;
        this.speed = speed;
        this.range = range;
        this.damege = damege;
    }

    @Override
    public void draw(Graphics2D g, GameField gameField) {
        getPoint();
        Toolkit t = Toolkit.getDefaultToolkit();
        Image img = t.getImage("res/img/" + this.getName_Entity());
        g.drawImage(img, getX_pos(), getY_pos(), gameField);
    }

}
