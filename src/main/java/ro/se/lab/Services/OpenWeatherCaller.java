package ro.se.lab.Services;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;

import java.net.http.HttpRequest;

public class OpenWeatherCaller {

    private static OWM owm = new OWM("c5de5cc9e7820ad61013a841b0512de0");

    public static void GetData(String city)
    {
        CurrentWeather currentWeather = new CurrentWeather();
        try {
            currentWeather = owm.currentWeatherByCityName(city);
        } catch (APIException e) {
            e.printStackTrace();
        }
        if(currentWeather.getRespCode() == 200)
        {
            // temperature
            System.out.println("T ~: " + ToCelsius(currentWeather.getMainData().getTemp()));
            // temperature max
            System.out.println("T max: " + ToCelsius(currentWeather.getMainData().getTempMax()));
            // temperature min
            System.out.println("T min: " + ToCelsius(currentWeather.getMainData().getTempMin()));
            // clouds
            System.out.println("Clouds(%): " + currentWeather.getCloudData().getCloud());
            // humidity
            System.out.println("Humidity: " + currentWeather.getMainData().getHumidity());
            // Wind Speed (m/s)
            System.out.println("Wind speed(m/s): " + currentWeather.getWindData().getSpeed());
            // Forecast
            System.out.println("test: " + currentWeather.getWeatherList().get(0).getMoreInfo());
            // IconCode
            System.out.println("test: " + currentWeather.getWeatherList().get(0).getIconCode());
        }
    }

    private static double ToCelsius(double tempK)
    {
        tempK -= 274.15;
        tempK = Math.round(tempK*100.0)/100.0;
        return tempK;
    }
}
