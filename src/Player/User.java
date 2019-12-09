package Player;

import Game.GameField;

import javax.swing.*;
import java.awt.*;

public class User  {

    public Player player;
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
    public String toString(){
        return String.valueOf(player.health)+" \n" +String.valueOf(player.money);
    }
    public int getHp(){
        return player.health;
    }
    public int getMoney(){
        return player.money;
    }
    public void draw(Graphics2D g){
        Toolkit t=Toolkit.getDefaultToolkit();
        Image image=t.getImage("res/img/coin.png");
        Image image1=t.getImage("res/img/like.png");
        Font font=new Font("Monaco",Font.BOLD,28);
        g.setFont(font);
        //g.drawString(user.toString(), 32 * 25, 32 * 10);
        g.setColor(Color.yellow);
        g.drawString(String.valueOf(player.money),32*25-5,32*11-6);
        g.drawImage(image,32*27,32*10,32,32,null);
        g.setColor(Color.RED);
        g.drawString(String.valueOf(player.health),32*25-5,32*13-6);
        g.drawImage(image1,27*32,32*12,32,32,null);


    }
}

