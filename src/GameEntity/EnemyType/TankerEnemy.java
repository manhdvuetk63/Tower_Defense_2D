package GameEntity.EnemyType;

import GameField.GameField;

import java.awt.*;

public class TankerEnemy extends Enemy {

    public TankerEnemy() {
        super(100,1,100,500);
        setName_Entity("Tanker.png");
        stt = RIGHT;
    }
}
