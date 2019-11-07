package GameEntity.EnemyType;

import java.awt.*;

public class NormalEnemy extends Enemy {
    String name="Normal.png";

    public NormalEnemy() {
        super(100, 100, 100, 100);
        setName_Entity(name);
    }

    public void draw(Graphics g) {
        Toolkit t=Toolkit.getDefaultToolkit();
        Image img= t.getImage("res/"+this.getName_Entity());
        g.drawImage(img,getX_pos(),getY_pos(),null);

    }

    @Override
    public void move() {

    }
}
