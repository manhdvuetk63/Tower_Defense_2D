package Map;


import Game.GameField;
import Load_res.UILoader;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Map {
    boolean isDraw = false;
    int a=0;

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
                    if (scanner.nextInt() == 1) {
                        HereCanBuild[i][j] = true;
                    } else HereCanBuild[i][j] = false;
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
                g.drawImage(image, j * 32, i * 32,32,32, drawPanel);

                //g.drawRect(j * 32, i * 32, 32, 32);
            }

        }
        Image i1=t.getImage("res/img/116.png");
        Image i2=t.getImage("res/img/112.png");
        Image i3=t.getImage("res/img/113.png");
        Image i4=t.getImage("res/img/111.png");
        Image i5=t.getImage("res/img/moutain.png");
        Image i6=t.getImage("res/img/moutain2.png");
        Image i7=t.getImage("res/img/plant.png");
        g.drawImage(i1,4*32,8*32,null);
        g.drawImage(i1,10*32,8*32,32,32,null);
        g.drawImage(i4,14*32,2*32,32,32,null);
        g.drawImage(i3,14*32,4*32,32,32,null);
        g.drawImage(i2,13*32,2*32,null);
        g.drawImage(i5,12*32,5*32,64,64,null);
        g.drawImage(UILoader.pauseButton,32*25,13*32,32*2,32,null);
    }




    public void DrawRect(Graphics2D g) {
        if(a++%100<50) g.setColor(Color.BLACK);
        else g.setColor(Color.WHITE);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 30; j++) {
                if (HereCanBuild[i][j] == true) {

                 //   ngang
                    g.fillRect(j * 32+4, i * 32+4, 10, 2);
                    g.fillRect(j * 32+32-10-4, i * 32+4, 10, 2);
                    g.fillRect(j * 32+4, i * 32+32-4, 10, 2);
                    g.fillRect(j * 32+32-10-4, i * 32+32-4, 10, 2);
//                    doc
                    g.fillRect(j * 32+4, i * 32+4, 2, 10);
                    g.fillRect(j * 32+32-4, i * 32+4, 2, 10);
                    g.fillRect(j * 32+4, i * 32+32-10-4, 2, 10);
                    g.fillRect(j * 32+32-4, i * 32+32-10-4, 2, 10);
                }
            }
        }
    }
}