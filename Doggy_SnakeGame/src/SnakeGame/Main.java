package SnakeGame;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    public Snake snake;
    public Food food;
    public Timeline timeline;
    
    private SceneManager sceneManager = new SceneManager();
    
    @Override
    public void start(Stage primaryStage) throws IOException{
        primaryStage.setTitle("Doggy_SnakeGame");
        
        sceneManager.buildMenu(primaryStage);
        primaryStage.show();
    }
    
    
    
    private void gameLoop(Stage primaryStage, Scene scene){
        if(Setting.GAMEOVER){
            BackGround.drawGameOver();
            timeline.stop();
            scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
                @Override
                public void handle(KeyEvent event){
                    KeyCode code = event.getCode();
                    if(code == KeyCode.SPACE){
                        Setting.GAMEOVER = false;
                        try {
                            sceneManager.buildMenu(primaryStage);
                        } catch (IOException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
            return;
        }
        
        BackGround.darwBackGround();
        food.draw();
        snake.draw();
        BackGround.drawScore(snake.score);
        
        switch(snake.derection){
            case "RIGHT":
                snake.moveRight();
                break;
            case "LEFT":
                snake.moveLeft();
                break;
            case "DOWN":
                snake.moveDown();
                break;
            case "UP":
                snake.moveUp();
                break;
        }
        
        isGameOver();
        
        if(snake.isEatFood(food)){
            timeline.setRate(Setting.curSpeedRate);
        }
    }
    
    public void isGameOver(){
        if(snake.snakeHead.x < 0 ||
           snake.snakeHead.y < 0 ||
           snake.snakeHead.x * Setting.SQUARE_SIZE >= Setting.WIDTH ||
           snake.snakeHead.y * Setting.SQUARE_SIZE >= Setting.HEIGHT){
            Setting.GAMEOVER = true;
        }
        if(Setting.STARTED){
            
            // someProblem
            for(int i = 1; i < snake.snakeBody.size(); i++){
                if(snake.snakeHead.x == snake.snakeBody.get(i).x && snake.snakeHead.y == snake.snakeBody.get(i).y){
                    Setting.GAMEOVER = true;
                    break;
                }
            }
        }
    }
    
}