package GameEntity.EnemyType;

import GameField.GameField;

import java.awt.*;

public class TankerEnemy extends Enemy {

    public TankerEnemy() {
        super(200, 1, 200, 200);
        setName_Entity("Tanker.png");
        stt = RIGHT;
        setY_pos(road.getListPoint()[0].y);
        setX_pos(road.getListPoint()[0].x);
    }
}
