package snake;

import javafx.scene.text.Font;

public class BackGround {
    public static void darwBackGround(){
        for(int r = 0; r  < Setting.ROWS; r++){
            for(int c = 0; c < Setting.COLS; c++){
                if((r + c) % 2 == 0){
                    Setting.GC.setFill(Setting.BG_COLOR_1);
                }else{
                    Setting.GC.setFill(Setting.BG_COLOR_2);
                }
                Setting.GC.fillRect(r * Setting.SQUARE_SIZE, c * Setting.SQUARE_SIZE, Setting.SQUARE_SIZE, Setting.SQUARE_SIZE);
            }
        }
    }
    
    public static void drawScore(int score){
        Setting.GC.setFill(Setting.SCORE_FONT_COLOR);
        Setting.GC.setFont(new Font(Setting.FONT_STYLE, Setting.FONT_SIZE));
        Setting.GC.fillText("Score:" + Integer.toString(score), 0, Setting.FONT_SIZE);
    }
}
