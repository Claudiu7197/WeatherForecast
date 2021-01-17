package ro.se.lab.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import ro.se.lab.Services.CurrentWeather;
import ro.se.lab.Services.OpenWeatherCaller;
import ro.se.lab.Services.WeatherService;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailedForecastController implements Initializable
{
    @FXML
    private Text precipitation;
    @FXML
    private Text humidity;
    @FXML
    private Text wind;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        assert precipitation != null : "fx:id=\"icon\" was not injected: check fxml file!";
        assert humidity != null : "fx:id=\"icon\" was not injected: check fxml file!";
        assert wind != null : "fx:id=\"icon\" was not injected: check fxml file!";
        WeatherService.InitDetailedController(this);
    }

    public void SetData()
    {
        CurrentWeather cw = OpenWeatherCaller.currentWeather;
        precipitation.setText("no value");
        if(cw.rain != null)
            precipitation.setText(String.valueOf(cw.rain.rainVolume) + "mm");
        if(cw.snow != null)
            precipitation.setText(String.valueOf(cw.snow.rainVolume) + "mm");
        humidity.setText(String.valueOf(cw.main.humidity)+"%");
        wind.setText(String.valueOf(cw.wind.speed)+"m/s");
    }

}
