package snake;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Setting {
    // game controll
    public static SceneManager SCENEMANAGER;
    protected static boolean STARTED = false;
    protected static boolean GAMEOVER = false;
    
    // background
    protected static Canvas CANVAS;
    protected static GraphicsContext GC;
    protected static int WIDTH = 525;
    protected static int HEIGHT = WIDTH;
    protected static int ROWS = 21;
    protected static int COLS = ROWS;
    protected static int SQUARE_SIZE = WIDTH / ROWS;
    protected static Color BG_COLOR = Color.web("ff9933");
    
    // font
    protected static String FONT_STYLE = "Digital-7";
    protected static int FONT_SIZE = 40;
    protected static Color SCORE_FONT_COLOR = Color.web("1f1e33");
    
    // snake
    protected static int curSpeed = 200;
    protected static double curSpeedRate = 1.0;
    protected static double SPEED_UP = 0.3;
    
    // paths
    protected static String MENU_SCENE_PATH = "/Scene/MenuScene.fxml";
    protected static String GAMEOVER_SCENE_PATH = "/Scene/GameOverScene.fxml";
    protected static String LEVEL_1_SCENE_PATH = "/Scene/Level_1.fxml";
    protected static String CSS_PATH = "/css/application.css";
    
    // images
    protected static String ICON_IMAGE_PATH = "/Image/Doggy_God's_Street.png";
    protected static  String KORONE_IMAGE_PATH = "/Image/Korone.png";
    protected static  String KORONE_LISTENER_IMAGE_PATH = "/Image/Korone_Listener.png";
    protected static String[] FOOD_IMAGES = new String[]{"/Image/yubi_1.png",
                                                                "/Image/yubi_2.png"};
    
    // sounds
    protected static String MENU_BGM = "/Sound/Doggy_god's_street.mp3";
    protected static String BGM = "/Sound/King_Dedede_Kirbys_Dream_Land_3.mp3";
    protected static String GAME_OVER_BGM = "/Sound/Evil_God_Korone_brainwashing_song.mp3";
    protected static String[] SE = new String[]{"/Sound/Yubi_Yubi.mp3",
                                                "/Sound/Yubi_Yubi_fast.mp3",
                                                "/Sound/Yeahhhyee.mp3"};
    protected static String GAME_OVER_SE = "/Sound/Korone_Scream.mp3";
    
    protected static double MENU_BGM_volume = 0.2;
    protected static double BGM_volume = 0.3;
    protected static double GAME_OVER_BGM_volume = 0.3;
    protected static double SE_volume = 0.5;
}
