package GameEntity.EnemyType;

public class NormalEnemy extends Enemy {
    String name="Normal.png";

    public NormalEnemy() {
        super(100, 100, 100, 100);
        setName_Entity(name);
    }

    @Override
    public void draw() {
    }

    @Override
    public void move() {

    }
}
