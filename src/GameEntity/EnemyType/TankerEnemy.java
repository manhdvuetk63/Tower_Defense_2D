package GameEntity.EnemyType;


import java.awt.*;
import java.util.Random;

public class TankerEnemy extends Enemy {
int i=0;
    public TankerEnemy() {
        super(6000,1,100,50);
        setName_Entity("Tanker.png");
        Random random=new Random();
        i=random.nextInt(4);
        switch (i) {
            case 0:
                setName_Entity("Tanker.png");
                break;
            case 1:
                setName_Entity("tank2.png");
                break;
            case 2:
                setName_Entity("tank_huge.png");
                break;
        }
        stt = RIGHT;
    }
}
