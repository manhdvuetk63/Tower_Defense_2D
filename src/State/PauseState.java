package State;

import Game.GameField;
import Load_res.UILoader;

import java.awt.*;
import java.awt.event.MouseEvent;

public class PauseState extends StatesOfGame {
    MouseEvent e;

    public PauseState(GameField gameField) {
        super(gameField);
    }

    public void draw(Graphics2D g2d) {
        if (e!=null){
            mousePressed(e);
        }
       // System.out.println(e.getX()+" "+e.getY());
        g2d.drawImage(UILoader.Pause, 10 * 32, 32 * 2, 32 * 10, 32 * 12, null);
        g2d.drawImage(UILoader.resumeButton, 12 * 32, 32 * 5, 32 * 6, 32 * 2, null);
        g2d.drawImage(UILoader.menuButton, 12 * 32, 32 * 8, 32 * 6, 32 * 2, null);
        g2d.drawImage(UILoader.quitButton, 12 * 32, 32 * 11, 32 * 6, 32 * 2, null);
        if (UILoader.isResumeButton) {
            g2d.drawImage(UILoader.resumeButtonClick, 12 * 32, 32 * 5, 32 * 6, 32 * 2, null);
            UILoader.isResumeButton=false;
        }
        if (UILoader.isMenuButton) {
            g2d.drawImage(UILoader.menuButtonClick, 12 * 32, 32 * 8, 32 * 6, 32 * 2, null);
            UILoader.isMenuButton=false;
        }
        if (UILoader.isQuitButton) {
            g2d.drawImage(UILoader.quitButtonClick, 12 * 32, 32 * 11, 32 * 6, 32 * 2, null);
            UILoader.isQuitButton=false;
        }
    }

    @Override
    public void mouseDown(MouseEvent e) {
    }

    @Override
    public void loadMenu(Graphics2D g) {

    }

    @Override
    public void loadGame(Graphics2D g) {

    }

    public void mousePressed(MouseEvent e) {
        if (e.getX() >= 12 * 32 && e.getX() <= 18 * 32) {
            if (e.getY() >= 32 * 6 && e.getY() <= 32 * 8) {
                UILoader.isResumeButton = true;
                UILoader.isMenuButton = false;
                UILoader.isQuitButton = false;
               this.gameField.scene=1;
                System.out.println("ok1");
            } else if (e.getY() >= 32 * 9 && e.getY() <= 32 * 9 + 64) {
                UILoader.isMenuButton = true;
                UILoader.isResumeButton = false;
                UILoader.isQuitButton = false;
                this.gameField.loadMenu();
                this.gameField.scene=0;
                System.out.println("ok2");
            } else if (e.getY() >= 32 * 12 && e.getY() <= 32 * 12 + 64) {
                UILoader.isQuitButton = true;
                UILoader.isMenuButton  = false;
                UILoader.isResumeButton = false;
                this.gameField.running = false;
                this.gameField.startGame();
            }
        }
    }
}
