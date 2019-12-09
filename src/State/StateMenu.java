package State;

import Game.GameField;
import Load_res.UILoader;

import java.awt.*;
import java.awt.event.MouseEvent;

public class StateMenu extends StatesOfGame {
    public StateMenu(GameField gameField) {
        super(gameField);
    }

    @Override
    public void mouseDown(MouseEvent e) {
    }

    public void loadMenu(Graphics2D g2d) {
        if (e != null) {
            mousePressed(e);
        }
        g2d.drawImage(UILoader.imageOfMenu, 0, 0, 32 * 30, 32 * 16, null);
        g2d.drawImage(UILoader.mainMenu, 10 * 32, 32 * 2, 32 * 10, 32 * 12, null);
        g2d.drawImage(UILoader.loadGameButton, 12 * 32, 32 * 5, 32 * 6, 32 * 2, null);
        g2d.drawImage(UILoader.newGameButton, 12 * 32, 32 * 8, 32 * 6, 32 * 2, null);
        g2d.drawImage(UILoader.quitButton, 12 * 32, 32 * 11, 32 * 6, 32 * 2, null);
        if (UILoader.isLoadGameButton) {
            g2d.drawImage(UILoader.loadGameButtonClick, 12 * 32, 32 * 5, 32 * 6, 32 * 2, null);
            UILoader.isLoadGameButton = false;
        }
        if (UILoader.isNewGameButton) {
            g2d.drawImage(UILoader.newGameButtonClick, 12 * 32, 32 * 8, 32 * 6, 32 * 2, null);
            UILoader.isNewGameButton = false;
        }
        if (UILoader.isQuitButton) {
            g2d.drawImage(UILoader.quitButtonClick, 12 * 32, 32 * 11, 32 * 6, 32 * 2, null);
            UILoader.isQuitButton = false;
        }
    }

    @Override
    public void loadGame(Graphics2D g) {

    }

    @Override
    public void draw(Graphics2D g) {

    }

    public void mousePressed(MouseEvent e) {
        if (e.getX() >= 12 * 32 && e.getX() <= 18 * 32) {
            if (e.getY() >= 32 * 6 && e.getY() <= 32 * 8) {
                UILoader.isLoadGameButton = true;
                UILoader.isNewGameButton = false;
                UILoader.isQuitButton = false;
                this.gameField.loadGame();
                this.gameField.startGame();
            } else if (e.getY() >= 32 * 9 && e.getY() <= 32 * 9 + 64) {
                UILoader.isNewGameButton = true;
                UILoader.isLoadGameButton = false;
                UILoader.isQuitButton = false;
                this.gameField.loadGame();
                this.gameField.startGame();
            } else if (e.getY() >= 32 * 12 && e.getY() <= 32 * 12 + 64) {
                UILoader.isQuitButton = true;
                UILoader.isLoadGameButton = false;
                UILoader.isNewGameButton = false;
                this.gameField.running = false;
                this.gameField.startGame();
            }
        }
    }
}

