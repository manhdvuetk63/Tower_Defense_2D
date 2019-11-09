package GameEntity.EnemyType;

import GameField.GameField;

import java.awt.*;

public class SmallerEnemy extends Enemy {

    public SmallerEnemy() {
        super(50, 1, 100, 200);
        setName_Entity("Smaller.png");
        stt = RIGHT;
        setY_pos(road.getListPoint()[0].y);
        setX_pos(road.getListPoint()[0].x);

    }

}
