package ro.se.lab.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import ro.se.lab.Services.WeatherService;

import java.net.URL;
import java.util.ResourceBundle;

public class BasicForecastController implements Initializable
{

    @FXML
    private Text cityName;
    @FXML
    private Text forecast;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        assert cityName != null : "fx:id=\"cityName\" was not injected: check fxml file!";
        assert forecast != null : "fx:id=\"forecast\" was not injected: check fxml file!";
        WeatherService.InitBasicController(this);
    }

    public void SetData(String city, String forecastText)
    {
        cityName.setText(city);
        forecast.setText(forecastText);
    }

}
