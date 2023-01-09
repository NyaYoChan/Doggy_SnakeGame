package snake;

import Scene.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SceneManager {
    public MediaPlayer BGMPlayer;
    public MediaPlayer SEPlayer;
    
    private Stage primaryStage;
    
    public SceneManager(Stage primaryStage){
        this.primaryStage = primaryStage;
    }
    
    public void buildMenu() throws IOException, URISyntaxException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Setting.MENU_SCENE_PATH));

        Parent root = loader.load();
        MenuSceneController controller = loader.getController();
        
        Scene scene = new Scene(root);
        
        String css = getClass().getResource(Setting.CSS_PATH).toExternalForm();
        scene.getStylesheets().add(css);
        
        Media bgm = new Media(getClass().getResource(Setting.MENU_BGM).toURI().toString());
        this.BGMPlayer = new MediaPlayer(bgm);
        this.BGMPlayer.setCycleCount(-1);
        this.BGMPlayer.setVolume(Setting.MENU_BGM_volume);
        this.BGMPlayer.play();
        
        primaryStage.setScene(scene);
    }
    
    public void buildGameOverScene() throws IOException, URISyntaxException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Setting.GAMEOVER_SCENE_PATH));
        Parent root = loader.load();
        GameOverSceneController controller = loader.getController();
        
        Scene scene = new Scene(root);
        
        String css = getClass().getResource(Setting.CSS_PATH).toExternalForm();
        scene.getStylesheets().add(css);
        
        primaryStage.setScene(scene);
        
        Media bgm = new Media(getClass().getResource(Setting.GAME_OVER_BGM).toURI().toString());
        this.BGMPlayer = new MediaPlayer(bgm);
        this.BGMPlayer.setCycleCount(-1);
        this.BGMPlayer.setVolume(Setting.GAME_OVER_BGM_volume);
        this.BGMPlayer.play();
        
        controller.translateTransition.play();
        controller.fadeTranslate.play();
    }
    
    public void buildLevel_1() throws URISyntaxException{
        Group root = new Group();

        Setting.CANVAS = new Canvas(Setting.WIDTH, Setting.HEIGHT);
        root.getChildren().add(Setting.CANVAS);

        Setting.GC = Setting.CANVAS.getGraphicsContext2D();

        Scene scene = new Scene(root, Setting.WIDTH, Setting.HEIGHT);
        
        String css = getClass().getResource(Setting.CSS_PATH).toExternalForm();
        scene.getStylesheets().add(css);

        Snake snake = new Snake();
        Food food = new Food(snake);

        scene.setOnKeyPressed(event -> {
            if(Setting.STARTED == false){
                Setting.STARTED = true;
            }
            KeyCode code = event.getCode();
            if(code == KeyCode.RIGHT || code == KeyCode.D){
                if(!snake.derection.equalsIgnoreCase("LEFT")){
                    snake.derection = "RIGHT";
                }
            }
            if(code == KeyCode.LEFT || code == KeyCode.A){
                if(!snake.derection.equalsIgnoreCase("RIGHT")){
                    snake.derection = "LEFT";
                }
            }
            if(code == KeyCode.DOWN || code == KeyCode.S){
                if(!snake.derection.equalsIgnoreCase("UP")){
                    snake.derection = "DOWN";
                }
            }
            if(code == KeyCode.UP || code == KeyCode.W){
                if(!snake.derection.equalsIgnoreCase("DOWN")){
                    snake.derection = "UP";
                }
            }
        });

        primaryStage.setScene(scene);
        
        Media bgm = new Media(getClass().getResource(Setting.BGM).toURI().toString());
        this.BGMPlayer = new MediaPlayer(bgm);
        this.BGMPlayer.setCycleCount(-1);
        this.BGMPlayer.setVolume(Setting.BGM_volume);
        
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.millis(Setting.curSpeed), e -> {
            try {
                run(scene, timeline, snake, food);
            } catch (IOException ex) {
                Logger.getLogger(SceneManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (URISyntaxException ex) {
                Logger.getLogger(SceneManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        
        Setting.curSpeedRate = 1.0;        
    }
    
     private void run(Scene scene, Timeline timeline, Snake snake, Food food) throws IOException, URISyntaxException{
        if(Setting.GAMEOVER){
            Media game_over_se = new Media(getClass().getResource(Setting.GAME_OVER_SE).toString());
            this.SEPlayer = new MediaPlayer(game_over_se);
            this.SEPlayer.setVolume(Setting.SE_volume);
            this.SEPlayer.play();
            this.SEPlayer.seek(Duration.seconds(0));
            
            this.BGMPlayer.stop();
            
            timeline.stop();
            
            buildGameOverScene();
            
            Setting.STARTED = false;
            Setting.GAMEOVER = false;
            
            return;
        }else{
            this.BGMPlayer.play();
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
        
        isGameOver(snake);
        
        if(snake.isEatFood(food)){   
            Media se = new Media(getClass().getResource(Setting.SE[(int)(Math.random() * Setting.SE.length)]).toString());
            this.SEPlayer = new MediaPlayer(se);
            this.SEPlayer.setVolume(Setting.SE_volume);
            this.SEPlayer.play();
            this.SEPlayer.seek(Duration.seconds(0));
            
            timeline.setRate(Setting.curSpeedRate);
        }
    }
    
    private void isGameOver(Snake snake){
        if(snake.snakeHead.x < 0 ||
           snake.snakeHead.y < 0 ||
           snake.snakeHead.x * Setting.SQUARE_SIZE >= Setting.WIDTH ||
           snake.snakeHead.y * Setting.SQUARE_SIZE >= Setting.HEIGHT){
           Setting.GAMEOVER = true;
        }
        
        if(Setting.STARTED){
            for(int i = 1; i < snake.snakeBody.size(); i++){
                if(snake.snakeHead.x == snake.snakeBody.get(i).x && snake.snakeHead.y == snake.snakeBody.get(i).y){
                    Setting.GAMEOVER = true;
                    break;
                }
            }
        }
    }
}
