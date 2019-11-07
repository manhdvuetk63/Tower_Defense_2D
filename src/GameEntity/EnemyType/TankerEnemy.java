package GameEntity.EnemyType;

import java.awt.*;

public class TankerEnemy extends Enemy {

    public TankerEnemy() {
        super(200, 80, 200, 200);
        setName_Entity("Tanker.png");
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
