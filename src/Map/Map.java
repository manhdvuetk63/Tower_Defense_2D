package Map;

import GameField.GameField;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Map {

    String[][] map = new String[15][30];

    public Map () {
        try {
            File file = new File("res\\img\\map.txt");
            Scanner scanner = new Scanner(file);
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 30; j++) {
                    map[i][j]=scanner.next();
                }
            }
        } catch (IOException e) {
            System.out.println("loi");
        }
    }

    public void Draw(Graphics g, GameField drawPanel) {
        Toolkit t = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 30; j++) {
                Image image = t.getImage("res/img/"+map[i][j] + ".jpg");
                g.drawImage(image, j *32 , i * 32 ,drawPanel);
            }
            System.out.println();
        }
    }
}
