package Map;

import GameField.GameField;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Map {
    boolean isDraw=false;

    String[][] map = new String[15][30];
    public boolean[][] HereCanBuild = new boolean[15][30];

    public Map() {
        try {
            File file = new File("res\\img\\map.txt");
            Scanner scanner = new Scanner(file);
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 30; j++) {
                    map[i][j] = scanner.next();
                }
            }
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 30; j++) {
                    if(scanner.nextInt()==1){
                        HereCanBuild[i][j]=true;
                    }
                    else HereCanBuild[i][j]=false;
                }
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void Draw(Graphics g, GameField drawPanel) {
            Toolkit t = Toolkit.getDefaultToolkit();
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 30; j++) {
                    Image image = t.getImage("res/img/" + map[i][j] + ".jpg");
                    g.drawImage(image, j * 32, i * 32, drawPanel);
                    //g.drawRect(j * 32, i * 32, 32, 32);
                }

        }
    }
}
