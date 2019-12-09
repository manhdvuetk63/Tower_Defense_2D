package Game;

import javax.swing.*;
import java.awt.*;

public class GameStage extends JFrame {

    public static void main(String[] args) {
        new GameStage();
    }

    public GameStage() throws HeadlessException {
        new JFrame();
        this.setTitle("Tower Defense ");
        this.setSize(32*30+16, 32*16+8);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        GameField gameField=new GameField(this);
        this.add(gameField);
        this.setVisible(true);
    }
}
