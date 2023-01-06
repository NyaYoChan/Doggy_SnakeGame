package Scene;

import SnakeGame.Setting;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MenuController implements Initializable {
    @FXML
    ImageView menuImageView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        menuImageView.setImage(new Image(Setting.MENU_IMAGE_PATH));
    }    
    
}
