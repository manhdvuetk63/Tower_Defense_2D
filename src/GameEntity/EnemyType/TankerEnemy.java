package GameEntity.EnemyType;


import java.awt.*;

public class TankerEnemy extends Enemy {

    public TankerEnemy() {
        super(3000,1,100,50);
        setName_Entity("Tanker.png");
        stt = RIGHT;
    }
}
