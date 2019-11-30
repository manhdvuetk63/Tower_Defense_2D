package Player;

public class Player {

     public int health;
    public int money;
    public Player(User user){
        this.health=user.startingHealth;
        this.money=user.startingHealth;
    }
}
