package ro.se.lab.Services;

import ro.se.lab.Controllers.*;
import ro.se.lab.Input.FileRead;

import javax.swing.*;

public class WeatherService
{
    private static String currentCity;
    private static String currentCountry;
    private static CityController cityController;
    private static CountryController countryController;
    private static BasicForecastController basicForecastController;
    private static DetailedForecastController detailedForecastController;
    private static IconController iconController;
    private static TemperatureController temperatureController;

    public static void InitCityController(CityController controller)
    {
        cityController = controller;
    }

    public static void InitCountryController(CountryController controller)    {
        countryController = controller;
        countryController.InitCountries(FileRead.countries);
    }

    public static void InitBasicController(BasicForecastController controller)
    {
        basicForecastController = controller;
    }

    public static void InitDetailedController(DetailedForecastController controller){
        detailedForecastController = controller;
    }

    public static void InitIconController(IconController controller)
    {
        iconController = controller;
    }

    public static void InitTemperatureController(TemperatureController controller){
        temperatureController = controller;
    }

    public static void OnCountryChanged(String value)    {
        if(cityController != null)
        {
            cityController.OnCountryChanged(value);
            currentCountry = value;
        }
    }

    public static void OnCityChanged(String value)    {
        currentCity = value;
        // call the server for data ->> data is stored in OpenWeatherCaller.CurrentWeather
        OpenWeatherCaller.GetData(currentCity, currentCountry);

        // Update the rest of the UI
        iconController.SetImage(OpenWeatherCaller.GetWeather().weather.get(0).icon);
        basicForecastController.SetData(currentCity, OpenWeatherCaller.GetWeather().weather.get(0).description);
        temperatureController.SetData(OpenWeatherCaller.GetWeather().main);
        detailedForecastController.SetData();
    }
}
