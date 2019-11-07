package GameEntity;

import GameField.GameField;

import java.awt.*;

public abstract class GameEntity {
    int x_pos;
    int y_pos;
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

    public abstract void draw(Graphics g, GameField gameField);
}