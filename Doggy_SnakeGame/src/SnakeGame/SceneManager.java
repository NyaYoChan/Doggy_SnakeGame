package SnakeGame;

import Scene.*;
import java.io.IOException;
import java.net.URL;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SceneManager {
    protected SceneManager(){}
    
    protected void buildMenu(Stage primaryStage) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Setting.MENU_SCENE_PATH));
        Parent root = loader.load();
        MenuController controller = loader.getController();
        
        Scene menu_scene = new Scene(root);
        
        // problem
        menu_scene.setOnKeyPressed(event -> {
           switch(event.getCode()){
               case SPACE:
                   System.out.println("HHW");
                   break; 
               default:
                   System.out.println(event.getCode());
                   break;
           }
        });
        
        primaryStage.setScene(menu_scene);
        
    }
    
//    private void buildLevel(Stage primaryStage){
//        Group root = new Group();
//
//        Setting.CANVAS = new Canvas(Setting.WIDTH, Setting.HEIGHT);
//        root.getChildren().add(Setting.CANVAS);
//
//        Setting.GC = Setting.CANVAS.getGraphicsContext2D();
//
//        Scene scene = new Scene(root, Setting.WIDTH, Setting.HEIGHT);
//
//        snake = new Snake();
//        food = new Food(snake);
//
//        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
//            @Override
//            public void handle(KeyEvent event){
//                if(Setting.STARTED == false){
//                    Setting.STARTED = true;
//                }
//                KeyCode code = event.getCode();
//                if(code == KeyCode.RIGHT || code == KeyCode.D){
//                    if(!snake.derection.equalsIgnoreCase("LEFT")){
//                        snake.derection = "RIGHT";
//                    }
//                }
//                if(code == KeyCode.LEFT || code == KeyCode.A){
//                    if(!snake.derection.equalsIgnoreCase("RIGHT")){
//                        snake.derection = "LEFT";
//                    }
//                }
//                if(code == KeyCode.DOWN || code == KeyCode.S){
//                    if(!snake.derection.equalsIgnoreCase("UP")){
//                        snake.derection = "DOWN";
//                    }
//                }
//                if(code == KeyCode.UP || code == KeyCode.W){
//                    if(!snake.derection.equalsIgnoreCase("DOWN")){
//                        snake.derection = "UP";
//                    }
//                }
//            }
//        });
//
//        primaryStage.setScene(scene);
//
//        timeline = new Timeline(new KeyFrame(Duration.millis(Setting.curSpeed), e -> run(primaryStage, scene)));
//        timeline.setCycleCount(Animation.INDEFINITE);
//        timeline.play();
//    }
}
