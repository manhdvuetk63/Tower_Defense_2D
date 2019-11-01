package Player;


import GameField.GameField;

public class User  {
    Player player;
    private GameField screen;
    int startingMoney=1000;
    int startingHealth=1000;

    public User (GameField screen) {
        this.screen = screen;
        this.screen.scene = 0;
    }
    public void createPlayer(){
        player=new Player(this);
    }
}
