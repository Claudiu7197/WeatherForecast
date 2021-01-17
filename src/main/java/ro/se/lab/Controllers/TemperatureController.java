package ro.se.lab.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import ro.se.lab.Services.OpenWeatherCaller;
import ro.se.lab.Services.WeatherClasses.Main;
import ro.se.lab.Services.WeatherService;

import java.net.URL;
import java.util.ResourceBundle;

public class TemperatureController implements Initializable
{
    private String celsius = "C";
    private String kelvin = "K";
    private boolean isKelvin;

    @FXML
    private Text temp;
    @FXML
    private Text feel;
    @FXML
    private Text minMax;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        assert temp != null : "fx:id=\"temp\" was not injected: check fxml file!";
        assert feel != null : "fx:id=\"temp\" was not injected: check fxml file!";
        assert minMax != null : "fx:id=\"temp\" was not injected: check fxml file!";
        WeatherService.InitTemperatureController(this);
    }

    public void SetData(Main main)
    {
        isKelvin = true;
        temp.setText(String.valueOf(main.temp)+kelvin);
        feel.setText(String.valueOf(main.feels_like)+kelvin);
        minMax.setText(String.valueOf(main.temp_min)+kelvin+"/"+String.valueOf(main.temp_max)+kelvin);
        ChangeUnit(new ActionEvent());
    }

    public void ChangeUnit(ActionEvent actionEvent)
    {
        if(isKelvin)
        {
            isKelvin = false;
            String newTemp = OpenWeatherCaller.GetWeather().main.ConvertToCelsius(Main.TEMP_TYPE.TEMP);
            temp.setText(newTemp+celsius);
            String newFeel = OpenWeatherCaller.GetWeather().main.ConvertToCelsius(Main.TEMP_TYPE.REALFEEL);
            feel.setText(newFeel+celsius);
            String newMin = OpenWeatherCaller.GetWeather().main.ConvertToCelsius(Main.TEMP_TYPE.TEMP_MIN);
            String newMax = OpenWeatherCaller.GetWeather().main.ConvertToCelsius(Main.TEMP_TYPE.TEMP_MAX);
            minMax.setText(newMin+celsius+"/"+newMax+celsius);
        }
        else
        {
            isKelvin = true;
            double newTemp = OpenWeatherCaller.GetWeather().main.temp;
            temp.setText(String.valueOf(newTemp)+kelvin);
            double newFeel = OpenWeatherCaller.GetWeather().main.feels_like;
            feel.setText(String.valueOf(newFeel)+kelvin);
            double newMin = OpenWeatherCaller.GetWeather().main.temp_min;
            double newMax = OpenWeatherCaller.GetWeather().main.temp_max;
            minMax.setText(String.valueOf(newMin)+kelvin+"/"+String.valueOf(newMax)+kelvin);
        }
    }


}
