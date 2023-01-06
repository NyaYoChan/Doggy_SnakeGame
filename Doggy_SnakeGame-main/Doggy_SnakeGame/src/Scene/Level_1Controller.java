package Scene;

import SnakeGame.Setting;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Level_1Controller implements Initializable {
    @FXML
    ImageView koroneImageView;
    
    private double curX;
    private double xSpeed = 1;
    
    int FPS = 60;
    double timePerFrame = Math.pow(10, 9) / FPS;
    long curTime;
    long lastTime = System.nanoTime();
    int frames = 0;
    long lastCheck = System.currentTimeMillis();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        koroneImageView.setImage(new Image(Setting.KORONE_IMAGE_PATH));
        curX = koroneImageView.getLayoutX();
    }    
    
    public void fixedUpdate(){
        moveRight();
    }
    
    public void update(){
//        System.out.println("HHW");
        curTime = System.nanoTime();
        if(curTime - lastTime >= timePerFrame){
            rendenPlayer();
            lastTime = curTime;
            frames++;
        }
        if(System.currentTimeMillis() - lastCheck >= 1000){
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS: " + frames);
            frames = 0;
        }
        
        ;
    }
    
    private void rendenPlayer(){
        koroneImageView.setLayoutX(curX);
    }
    
    private void moveRight(){
        curX++;
//        rendenPlayer();
    }
    
}
