package ro.se.lab.Controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import ro.se.lab.Input.Country;
import ro.se.lab.Input.FileRead;
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
        WeatherService.InitCityController(this);

        // On item changed
        cityBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                WeatherService.OnCityChanged(newValue);
            }
        });
    }

    public void OnCountryChanged(String value)
    {
        list = cityBox.getItems();
        list.clear();
        for(Country c : FileRead.countries)
        {
            if(c.CountryName.equals(value))
            {
                for(String city : c.cities)
                    list.add(city);
            }
        }
    }
}
