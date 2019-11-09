package GameEntity.EnemyType;

import GameField.GameField;

import java.awt.*;

public class NormalEnemy extends Enemy {
    String name="Normal.png";
    public NormalEnemy() {
        super(100, 1, 100, 100);
        setName_Entity(name);
        stt = RIGHT;
        setY_pos(road.getListPoint()[0].y);
        setX_pos(road.getListPoint()[0].x);
    }
}
