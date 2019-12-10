package GameEntity.EnemyType;


import java.awt.*;
import java.util.Random;

public class BossEnemy extends Enemy {
    int i = 0;

    public BossEnemy() {
        super(50000, 1, 100, 500);
        Random random = new Random();
        i = random.nextInt(10);
        if (i % 2 == 0) {
            setName_Entity("bossEnemy.png");
        } else
            setName_Entity("Boss.png");
        stt = RIGHT;
    }
}
