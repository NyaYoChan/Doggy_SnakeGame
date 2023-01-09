package snake;

import javafx.scene.text.Font;

public class BackGround {
    public static void darwBackGround(){
        Setting.GC.setFill(Setting.BG_COLOR);
        Setting.GC.fillRect(0, 0, Setting.WIDTH, Setting.HEIGHT);
    }
    
    public static void drawScore(int score){
        Setting.GC.setFill(Setting.SCORE_FONT_COLOR);
        Setting.GC.setFont(new Font(Setting.FONT_STYLE, Setting.FONT_SIZE));
        Setting.GC.fillText("Score:" + Integer.toString(score), 0, Setting.FONT_SIZE);
    }
}
