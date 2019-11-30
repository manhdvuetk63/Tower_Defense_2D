package GameEntity.EnemyType;



import java.awt.*;

public class BossEnemy extends Enemy {
    public BossEnemy() {
        super(5000,1,100,500);
        setName_Entity("Boss.png");
        stt = RIGHT;
    }
}
