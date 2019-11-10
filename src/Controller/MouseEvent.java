package Controller;

import GameField.GameField;

import java.awt.event.InputEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseEvent implements MouseListener, MouseMotionListener {
    private GameField gameField;
    private GameField.MouseType mouseType;

    public MouseEvent(GameField gameField) {
        this.gameField = gameField;
        this.mouseType = this.gameField.new MouseType();
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        this.mouseType.mouseDown(e);
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {


    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {
        this.mouseType.mouseMoved(e);

    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
        this.mouseType.mouseMoved(e);
    }
}
