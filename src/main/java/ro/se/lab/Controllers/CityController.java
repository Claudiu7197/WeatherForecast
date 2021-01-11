package ro.se.lab.Controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import ro.se.lab.Services.WeatherService;

import java.net.URL;
import java.util.ResourceBundle;

public class CityController implements Initializable {
    @FXML
    private ChoiceBox<String> cityBox;
    private ObservableList<String> list;

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources)
    {
        assert cityBox != null : "fx:id=\"countryBox\" was not injected: check fxml file!";
        list = cityBox.getItems();
        WeatherService.InitCityController(this);
        OnCountryChanged(WeatherService.GetCurrentCountry());
    }

    public void OnCountryChanged(String value)
    {
        if(value.equals("England"))
        {
            list.clear();
            list.add("London");
            list.add("Manchester");
            cityBox.setValue(list.get(0));
        }
        if(value.equals("Portugal"))
        {
            list.clear();
            list.add("Lisabon");
            list.add("Well mate I don't know");
            cityBox.setValue(list.get(0));
        }
    }
}
