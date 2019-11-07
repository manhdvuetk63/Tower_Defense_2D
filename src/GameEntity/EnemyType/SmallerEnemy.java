package GameEntity.EnemyType;

import java.awt.*;

public class SmallerEnemy extends Enemy {

    public SmallerEnemy() {
        super(50,200, 100, 200);
        setName_Entity("Smaller.png");
    }

    @Override
    public void draw(Graphics g) {
        Toolkit t=Toolkit.getDefaultToolkit();
        Image img= t.getImage("res/"+this.getName_Entity());
        g.drawImage(img,getX_pos(),getY_pos(),null);

    }
    @Override
    public void move() {

    }
}
