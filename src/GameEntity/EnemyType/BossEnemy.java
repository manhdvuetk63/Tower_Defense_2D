package GameEntity.EnemyType;

import GameField.GameField;

import java.awt.*;

public class BossEnemy extends Enemy {
    public BossEnemy() {
        super(100,1,100,500);
        setName_Entity("Boss.png");
        stt = RIGHT;
    }
}
