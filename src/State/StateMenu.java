package State;

import Load_res.ImageLoader;
import Load_res.UILoader;

import java.awt.*;
import java.io.File;

public class StateMenu {

    public void loadMenu( Graphics2D g2d) {
        g2d.drawImage(UILoader.imageOfMenu,0,0,null);
       // g2d.drawImage(UILoader.mainMenu,, 50, 500, 500, null);
        g2d.drawImage(UILoader.loadGameButton, 445, 140, 270, 115, null);
        g2d.drawImage(UILoader.newGameButton, 445, 275, 270, 115, null);
        g2d.drawImage(UILoader.quitButton, 445, 410, 270, 115, null);
        if (UILoader.isLoadGameButton) {
            g2d.drawImage(UILoader.loadGameButtonClick, 445, 140, 270, 115, null);
        }
        if (UILoader.isNewGameButton) {
            g2d.drawImage(UILoader.newGameButtonClick, 445, 275, 270, 115, null);
        }
        if (UILoader.isQuitButton) {
            g2d.drawImage(UILoader.quitButtonClick, 445, 410, 270, 115, null);
        }
    }

}
