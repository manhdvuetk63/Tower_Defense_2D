package GameEntity.EnemyType;


import java.awt.*;
import java.util.Random;

public class NormalEnemy extends Enemy {
    String name = "Normal.png";
    int i = 0;

    public NormalEnemy() {
        super(4000, 1, 100, 50);
        Random random=new Random();
        i=random.nextInt(3);
        switch (i) {
            case 0:
                setName_Entity(name);
                break;
            case 1:
                setName_Entity("normal2.png");
                break;
            case 2:
                setName_Entity("normal1.png");
                break;
            case 3:
                setName_Entity("normal1.png");
                break;

        }
        stt = RIGHT;
    }
}
