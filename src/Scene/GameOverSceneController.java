package Scene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import snake.Setting;

public class GameOverSceneController implements Initializable {
    public TranslateTransition translateTransition;
    public FadeTransition fadeTranslate;
            
    @FXML
    private Button backToMenuButton;
    @FXML
    private Button newGameButton;
    
    @FXML
    private ImageView gameOverImageView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.translateTransition = new TranslateTransition();
        this.translateTransition.setNode(gameOverImageView);
        this.translateTransition.setDuration(Duration.millis(1000));
        this.translateTransition.setCycleCount(1);
        this.translateTransition.setByY(161);
        
        this.fadeTranslate = new FadeTransition();
        this.fadeTranslate.setNode(gameOverImageView);
        this.fadeTranslate.setDuration(Duration.millis(950));
        this.fadeTranslate.setCycleCount(FadeTransition.INDEFINITE);
        this.fadeTranslate.setInterpolator(Interpolator.LINEAR);
        this.fadeTranslate.setFromValue(0);
        this.fadeTranslate.setToValue(1);
    }

    public void buttonEvent(ActionEvent event) throws IOException{
        Button buttonOnPressed = (Button)event.getSource();
        switch(buttonOnPressed.getId()){
            case "backToMenuButton":
                Setting.SCENEMANAGER.BGMPlayer.stop();
                try{
                    Setting.SCENEMANAGER.buildMenu();
                }catch(Exception e){
                    System.out.println(e);
                }
                break;
            case "newGameButton":
                Setting.SCENEMANAGER.BGMPlayer.stop();
                try{
                    Setting.SCENEMANAGER.buildLevel_1();
                }catch(Exception e){
                    System.out.println(e);
                }
                break;
        }
    }
}
