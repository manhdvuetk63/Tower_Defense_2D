package Player;

import Game.GameField;

public class User  {

    public Player player;
    private GameField screen;
    int startingMoney=1000;
    int startingHealth=100;

    public User (GameField screen) {
        this.screen = screen;
        this.screen.scene = 0;
    }
    public void createPlayer(){
        player=new Player(this);
    }
    public String toString(){
        return String.valueOf(player.health)+" \n" +String.valueOf(player.money);
    }
}

