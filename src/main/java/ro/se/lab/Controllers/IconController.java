package ro.se.lab.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ro.se.lab.Services.WeatherClasses.Main;
import ro.se.lab.Services.WeatherService;

import java.net.URL;
import java.util.ResourceBundle;

public class IconController implements Initializable {

    @FXML
    private ImageView icon;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        assert icon != null : "fx:id=\"icon\" was not injected: check fxml file!";
        WeatherService.InitIconController(this);
    }

    public void SetImage(String iconCode)
    {
        Image image = new Image("http://openweathermap.org/img/wn/"+iconCode+"@2x.png");
        icon.setImage(image);
    }

}


