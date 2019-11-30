package GameEntity.EnemyType;


import java.awt.*;

public class NormalEnemy extends Enemy {
    String name="Normal.png";
    public NormalEnemy() {
        super(3000,1,100,50);
        setName_Entity(name);
        stt = RIGHT;
    }
}
