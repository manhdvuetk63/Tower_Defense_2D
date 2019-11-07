package GameEntity.TowerType;

import java.awt.*;

public class MachineGunTower extends Tower {


    public MachineGunTower() {
        super(100,200,64,50);
        setName_Entity("Machine.png");
    }

    public void draw(Graphics g) {
        Toolkit t=Toolkit.getDefaultToolkit();
        Image img= t.getImage("res/"+this.getName_Entity());
        g.drawImage(img,getX_pos(),getY_pos(),null);

    }
}
