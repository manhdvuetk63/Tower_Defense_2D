package GameEntity.TowerType;

import GameEntity.GameEntity;
import GameField.GameField;

import java.awt.*;

public abstract class Tower extends GameEntity {
    int cost,speed,range,damege;
    public Tower(int cost, int speed, int range, int damege) {
        this.cost = cost;
        this.speed = speed;
        this.range = range;
        this.damege = damege;
    }

    @Override
    public void draw(Graphics g, GameField gameField) {
        Toolkit t=Toolkit.getDefaultToolkit();
        Image img= t.getImage("res/img/"+this.getName_Entity());
        g.drawImage(img,getX_pos(),getY_pos(),null);
    }
}
