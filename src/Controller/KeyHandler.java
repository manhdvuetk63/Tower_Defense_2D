package Controller;


import GameField.GameField;
import GameStage.GameStage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private GameField screen;
    private GameField.KeyTyped KeyType;

    public KeyHandler(GameField screen) {
        this.screen = screen;
        this.KeyType = this.screen.new KeyTyped();
    }
    public void keyTyped(KeyEvent keyEvent) {
    }
    public void keyPressed(KeyEvent keyEvent) {
        int keycode=keyEvent.getKeyCode();
        System.out.println(keycode);
        if(keycode==27) {
            this.KeyType.keyESC();
        }
        if(keycode==32){
            this.KeyType.keySpace();
        }
    }
    public void keyReleased(KeyEvent keyEvent) {

    }
}
