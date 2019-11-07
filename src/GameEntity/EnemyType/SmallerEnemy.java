package GameEntity.EnemyType;

import GameField.GameField;

import java.awt.*;

public class SmallerEnemy extends Enemy {

    public SmallerEnemy() {
        super(50,200, 100, 200);
        setName_Entity("Smaller.png");
        stt=RIGHT;
        setY_pos(road.getListPoint()[0].y);
        setX_pos(road.getListPoint()[0].x);

    }

    @Override
    public void draw(Graphics g, GameField gameField) {
        Toolkit t=Toolkit.getDefaultToolkit();
        Image img= t.getImage("res/img/"+this.getName_Entity());
        g.drawImage(img,getX_pos(),getY_pos(),gameField);
        updateStatus();
        move();

    }
    @Override
    public void move() {
        switch (stt){
            case RIGHT:
                setX_pos(getX_pos()+1);
                break;
            case LEFT:
                setX_pos(getX_pos()-1);
                break;
            case DOWN:
                setY_pos(getY_pos()+1);
                break;
            case UP:
                setY_pos(getY_pos()-1);
                break;
        }
        if(getX_pos()==768) setHP(0);
    }
}
