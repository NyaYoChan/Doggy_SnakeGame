package Scene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import snake.Setting;

public class MenuSceneController implements Initializable {
    @FXML
    private Button startButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void buttonEvent(ActionEvent event) throws IOException{
        Button buttonOnPressed = (Button)event.getSource();
        switch(buttonOnPressed.getId()){
            case "startButton":
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
