package GameEntity.EnemyType;


import java.awt.*;
import java.util.Random;

public class SmallerEnemy extends Enemy {
    int i;

    public SmallerEnemy() {
        super(2000, 2, 100, 50);
        setName_Entity("Smaller.png");
        Random random=new Random();
        i=random.nextInt(4);
        switch (i) {
            case 0:
                setName_Entity("Smaller.png");
                break;
            case 1:
                setName_Entity("small1.png");
                break;
            case 2:
                setName_Entity("small2.png");
                break;
            case 3:
                setName_Entity("small3.png");
                break;

        }
        stt = RIGHT;
    }

}
