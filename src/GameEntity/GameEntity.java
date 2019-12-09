package GameEntity;


import Game.GameField;

import java.awt.*;
import java.io.IOException;

public abstract class GameEntity {
    protected int x_pos;
    protected int y_pos;
    public Point point;
    protected int width;
    protected int height;
    protected double rotationRequired=0;
    protected double xDistance;
    protected double yDistance;
    protected String name_Entity;
    public String getName_Entity() {
        return name_Entity;
    }

    public double getRotationRequired() {
        return rotationRequired;
    }

    public void setRotationRequired(double rotationRequired) {
        this.rotationRequired = rotationRequired;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setPoint() {
        point=new Point((int)getX_pos()+width/2,(int)getY_pos()+height/2);
        this.point = point;
    }
    public void setY_pos(int y_pos) {
        this.y_pos = y_pos;
    }
    public Point getPoint(){
        setPoint();
        return point;
    }
    public abstract void draw(Graphics2D g) throws IOException;
    public void findRotationRequired(Point p){
        xDistance=getPoint().x-p.x;
        yDistance=getPoint().y-p.y;
        if (xDistance==0){
            rotationRequired=90;
        }else
        rotationRequired=Math.atan(yDistance/xDistance);
    }
}