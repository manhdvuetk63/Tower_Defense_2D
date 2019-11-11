package GameEntity.EnemyType;

import GameField.GameField;

import java.awt.*;

public class SmallerEnemy extends Enemy {

    public SmallerEnemy() {
        super(2000,1,100,500);
        setName_Entity("Smaller.png");
        stt = RIGHT;
    }

}
