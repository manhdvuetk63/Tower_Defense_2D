package GameEntity;


import Game.GameField;

import java.awt.*;
import java.io.IOException;

public abstract class GameEntity {
    int x_pos;
    int y_pos;
    public Point point;
    String name_Entity;
    public String getName_Entity() {
        return name_Entity;
    }

    public void setName_Entity(String name_Entity) {
        this.name_Entity = name_Entity;
    }


    public int getX_pos() {
        return x_pos;
    }

    public void setX_pos(int x_pos) {
        this.x_pos = x_pos;
    }

    public int getY_pos() {
        return y_pos;
    }

    public void setY_pos(int y_pos) {
        this.y_pos = y_pos;
    }
    public void getPoint(){
        point=new Point(getX_pos()+16,getY_pos()+16);
    }
    public double range(Point p){
        double a=Math.sqrt((p.getX()-point.getX())*(p.getX()-point.getX())+(point.getY()-p.getY())*(point.getY()-p.getY()));
        return a;
    }

    public abstract void draw(Graphics2D g, GameField gameField) throws IOException;
}