package SnakeGame;

import Scene.*;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        // problem???
        menu_scene.setOnKeyPressed(event -> {
           switch(event.getCode()){
               case SPACE:
                   try {
                        buildLevel(primaryStage);
                   } catch (IOException ex) {
                        Logger.getLogger(SceneManager.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   break;  
               default:
                   System.out.println(event.getCode());
                   break;
           }
        });
        
        primaryStage.setScene(menu_scene);
        
    }
    
    protected void buildLevel(Stage primaryStage) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Setting.LEVEL_1_SCENE_PATH));
        Parent root = loader.load();
        Level_1Controller controller = loader.getController();
//
//        Setting.CANVAS = new Canvas(Setting.WIDTH, Setting.HEIGHT);
//        root.getChildren().add(Setting.CANVAS);
//
//        Setting.GC = Setting.CANVAS.getGraphicsContext2D();
//
        Scene scene = new Scene(root);
//
//        snake = new Snake();
//        food = new Food(snake);
//
        scene.setOnKeyPressed(event -> {
            switch(event.getCode()){
                case LEFT:
                    System.out.println("Left");
                    break;
                    
            }
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
        });
//
        primaryStage.setScene(scene);

        // sometime has some problems
        Timeline fixedUpdateTimeline = new Timeline(new KeyFrame(Duration.millis(0.2), e -> controller.fixedUpdate()));
        fixedUpdateTimeline.setCycleCount(Animation.INDEFINITE);
        fixedUpdateTimeline.play();
        
        Timeline updateTimeline = new Timeline(new KeyFrame(Duration.millis(0.1), e -> controller.update()));
        updateTimeline.setCycleCount(Animation.INDEFINITE);
        updateTimeline.play();
//        
//        System.out.println(updateTimeline.getOnFinished());
    }
}
