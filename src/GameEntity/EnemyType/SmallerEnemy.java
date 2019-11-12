package GameEntity.EnemyType;

import GameField.GameField;

import java.awt.*;

public class SmallerEnemy extends Enemy {

    public SmallerEnemy() {
        super(2000,2,100,50);
        setName_Entity("Smaller.png");
        stt = RIGHT;
    }

}
