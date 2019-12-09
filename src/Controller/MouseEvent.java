package Controller;

import Game.GameField;
import State.StatesOfGame;

import java.awt.event.InputEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseEvent implements MouseListener, MouseMotionListener {
    private GameField gameField;

    public MouseEvent(GameField gameField) {
        this.gameField = gameField;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        if (this.gameField.scene == 0) {
            this.gameField.stateMenu.setE(e);
        } else if (this.gameField.scene == 1) {
            this.gameField.stateGame.mouseDown(e);
        } else if (this.gameField.scene == 3) {
            this.gameField.pauseGame.mousePressed(e);

        } else this.gameField.gameOver.mousePressed(e);

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
        if (this.gameField.scene == 0) {
            this.gameField.stateMenu.setE(e);
        } else if (this.gameField.scene == 1) {
            this.gameField.stateGame.mouseMoved(e);
        } else if (this.gameField.scene == 3) {
            this.gameField.pauseGame.setE(e);

        } else this.gameField.gameOver.mousePressed(e);

    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
        if (this.gameField.scene == 0) {
            //  this.gameField.stateMenu.setE(e);
        } else if (this.gameField.scene == 1) {
            this.gameField.stateGame.mouseMoved(e);
        } else if (this.gameField.scene == 3) {
            // this.gameField.pauseGame.setE(e);

        }
        //else this.gameField.gameOver.mousePressed(e);
    }
}
