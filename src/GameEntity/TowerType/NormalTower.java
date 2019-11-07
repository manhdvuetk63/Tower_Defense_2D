package GameEntity.TowerType;

import java.awt.*;

public class NormalTower extends Tower {
    public NormalTower() {
        super(100,100,128,100);
        setName_Entity("NormalTower.png");
    }

    public void draw(Graphics g) {
        Toolkit t=Toolkit.getDefaultToolkit();
        Image img= t.getImage("res/"+this.getName_Entity());
        g.drawImage(img,getX_pos(),getY_pos(),null);
    }
}

