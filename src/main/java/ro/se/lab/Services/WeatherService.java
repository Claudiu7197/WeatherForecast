package ro.se.lab.Services;

import ro.se.lab.Controllers.CityController;
import ro.se.lab.Controllers.CountryController;

public class WeatherService
{
    private static CityController cityController;
    private static CountryController countryController;


    public static void InitCityController(CityController controller)
    {
        cityController = controller;
    }

    public static void InitCountryController(CountryController controller)
    {
        countryController = controller;
    }

    public static void OnCountryChanged(String value)
    {
        if(cityController != null)
            cityController.OnCountryChanged(value);
    }

    public static String GetCurrentCountry()
    {
        return countryController.getCurrentCountry();
    }

}
