package GameEntity.TowerType;

import GameField.GameField;

import java.awt.*;

public class SniperTower extends Tower {
    public SniperTower() {
        super(100,80,168,100);
        setName_Entity("Sniper.png");
    }

    public void draw(Graphics g) {
        Toolkit t=Toolkit.getDefaultToolkit();
        Image img= t.getImage("res/"+this.getName_Entity());
        g.drawImage(img,getX_pos(),getY_pos(),null);

    }

    @Override
    public void draw(Graphics g, GameField gameField) {

    }
}
