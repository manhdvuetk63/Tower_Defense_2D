package GameEntity.EnemyType;

import GameField.GameField;

import java.awt.*;

public class BossEnemy extends Enemy {
    public BossEnemy() {
        super(500, 1,100,1000);
        setName_Entity("Boss.png");
        stt = RIGHT;
        setY_pos(road.getListPoint()[0].y);
        setX_pos(road.getListPoint()[0].x);
    }
}
