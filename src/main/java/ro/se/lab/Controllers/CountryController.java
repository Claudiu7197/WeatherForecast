package ro.se.lab.Controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;
import ro.se.lab.Input.Country;
import ro.se.lab.Services.WeatherService;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CountryController implements Initializable {

    @FXML
    private ChoiceBox<String> countryBox;

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources)
    {
        assert countryBox != null : "fx:id=\"countryBox\" was not injected: check fxml file!";
        WeatherService.InitCountryController(this);


        // On item changed
        countryBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                WeatherService.OnCountryChanged(newValue);
            }
        });
    }

    public void InitCountries(ArrayList<Country> countries)
    {
        ObservableList<String> list = countryBox.getItems();
        for(Country c : countries)
        {
            list.add(c.CountryName);
        }
    }
}
