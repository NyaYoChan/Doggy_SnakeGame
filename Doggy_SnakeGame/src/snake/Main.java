package snake;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;



public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("SnakeGame");
        
        Image iconImage = new Image(getClass().getResource(Setting.ICON_IMAGE_PATH).toString());
        primaryStage.getIcons().add(iconImage);
        
        primaryStage.setResizable(false);
        
        Setting.SCENEMANAGER = new SceneManager(primaryStage);
        Setting.SCENEMANAGER.buildMenu();
//        Setting.SCENEMANAGER.buildGameOverScene();
        
        primaryStage.show();
    }
    
}