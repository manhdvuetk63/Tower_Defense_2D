package GameEntity.EnemyType;

import GameField.GameField;

import java.awt.*;

public class NormalEnemy extends Enemy {
    String name="Normal.png";
    public NormalEnemy() {
        super(100,1,100,500);
        setName_Entity(name);
        stt = RIGHT;
    }
}
