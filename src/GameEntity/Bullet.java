package GameEntity;

import GameField.GameField;

import java.awt.*;

public class Bullet extends GameEntity {
   public Bullet(){
       setName_Entity("Bullet.png");
   }
    public void move(){

    }
    public void draw() {

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
