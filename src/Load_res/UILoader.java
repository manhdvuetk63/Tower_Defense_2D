package Load_res;

import java.awt.*;

public class UILoader {
    //image MenuState
    public static Image mainMenu = ImageLoader.getImage("res/img/mainMenu.png");
    public static Image loadGameButton = ImageLoader.getImage("res/img/loadGameButton.png");
    public static Image loadGameButtonClick = ImageLoader.getImage("res/img/loadGameButtonClick.png");
    public static Image newGameButton = ImageLoader.getImage("res/img/newGameButton.png");
    public static Image newGameButtonClick = ImageLoader.getImage("res/img/newGameButtonClick.png");

    //image GameState
    public static Image startButton = ImageLoader.getImage("res/img/startButton.png");
    public static Image startButtonClick = ImageLoader.getImage("res/img/startButtonClick.png");
    public static Image pauseButton = ImageLoader.getImage("res/img/pauseButton.png");
    public static Image pauseButtonClick = ImageLoader.getImage("res/img/pauseButtonClick.png");
    public static Image heart = ImageLoader.getImage("res/img/heart.png");
    public static Image gold = ImageLoader.getImage("res/img/$.png");

    //image PauseState
    public static Image Pause = ImageLoader.getImage("res/img/Pause.png");
    public static Image resumeButton = ImageLoader.getImage("res/img/resumeButton.png");
    public static Image resumeButtonClick = ImageLoader.getImage("res/img/resumeButtonClick.png");
    public static Image menuButton = ImageLoader.getImage("res/img/menuButton.png");
    public static Image menuButtonClick = ImageLoader.getImage("res/img/menuButtonClick.png");

    //image GameOverState
    public static Image gameOver = ImageLoader.getImage("res/img/gameOver.png");
    public static Image restartButton = ImageLoader.getImage("res/img/restartButton.png");
    public static Image restartButtonClick = ImageLoader.getImage("res/img/restartButtonClick.png");

    public static Image imageOfMenu = ImageLoader.getImage("res/img/imageMenu.png");
    public static Image BG = ImageLoader.getImage("res/img/BG.png");

    public static Image quitButton = ImageLoader.getImage("res/img/quitButton.png");
    public static Image quitButtonClick = ImageLoader.getImage("res/img/quitButtonClick.png");

    //check MousePressed
    public static boolean isLoadGameButton = false;
    public static boolean isNewGameButton = false;
    public static boolean isStartButton = false;
    public static boolean isPauseButton = false;
    public static boolean isResumeButton = false;
    public static boolean isRestartButton = false;
    public static boolean isMenuButton = false;
    public static boolean isQuitButton = false;

}
