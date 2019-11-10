package GameEntity.EnemyType;

import GameField.GameField;

import java.awt.*;

public class SmallerEnemy extends Enemy {

    public SmallerEnemy() {
        super(100,1,100,500);
        setName_Entity("Smaller.png");
        stt = RIGHT;
    }

}
