package GameEntity;

import GameEntity.TowerType.Tower;
import GameField.GameField;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Bullet extends GameEntity {
    int timeFire;
    int speed;
    int dir;
    public Bullet() {
        setName_Entity("Bullet.png");

    }

    public void move() {

    }

    public void draw() {

    }

    public void draw(Graphics g) {
        Toolkit t = Toolkit.getDefaultToolkit();
        Image img = t.getImage("res/" + this.getName_Entity());

    }

    @Override
    public void draw(Graphics g, GameField gameField) {

    }
}
