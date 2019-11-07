package GameEntity.EnemyType;

import GameField.GameField;

import java.awt.*;

public class BossEnemy extends Enemy {
    public BossEnemy() {
        super(500, 50,100,1000);
        setName_Entity("Boss.png");
    }

    public void draw(Graphics g) {
        Toolkit t=Toolkit.getDefaultToolkit();
        Image img= t.getImage("res/"+this.getName_Entity());
        g.drawImage(img,getX_pos(),getY_pos(),null);

    }

    @Override
    public void move() {

    }

    @Override
    public void draw(Graphics g, GameField gameField) {

    }
}
