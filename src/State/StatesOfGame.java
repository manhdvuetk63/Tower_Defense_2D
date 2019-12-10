package State;


import Game.GameField;
import Load_res.GameSound;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class StatesOfGame {
    GameField gameField;
    GameSound gameSoundbg;
    protected MouseEvent e;
    protected int x_pos;
    protected int y_pos;
    protected int stt;
    protected boolean hasSound;

    public StatesOfGame(GameField gameField){
        gameSoundbg=new GameSound();
        this.gameField=gameField;
        hasSound=true;
    }
    public MouseEvent getE() {
        return e;
    }

    public void setE(MouseEvent e) {
        this.e = e;
    }

    public void mouseMoved(java.awt.event.MouseEvent e) {
        x_pos = e.getX() / 32;
        y_pos = e.getY() / 32 - 1;
    }
    public abstract void mouseDown(MouseEvent e);

    public abstract void loadMenu(Graphics2D g);

    public abstract void loadGame(Graphics2D g);

    public abstract void draw(Graphics2D g);

    public abstract void mousePressed(MouseEvent e);
    public abstract void playSFX();
}
