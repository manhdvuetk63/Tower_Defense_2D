package GameEntity.TowerType;

import GameEntity.GameTile;
import GameField.GameField;

import java.awt.*;

public abstract class Tower extends GameTile {
    Point pos;
    public Tower(int cost, int speed, int range, int damage) {
        super(cost, speed, range, damage);
    }

    @Override
    public void draw(Graphics g, GameField gameField) {
        Toolkit t=Toolkit.getDefaultToolkit();
        Image img= t.getImage("res/img/"+this.getName_Entity());
        g.drawImage(img,getX_pos(),getY_pos(),null);
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }

    public Point getPos() {
        return pos;
    }

}
