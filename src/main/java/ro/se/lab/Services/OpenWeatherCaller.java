package ro.se.lab.Services;

import com.google.gson.Gson;
import javafx.scene.Parent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenWeatherCaller {

    private static String key = "c5de5cc9e7820ad61013a841b0512de0";
    public static CurrentWeather currentWeather;

    public static void GetData(String city, String country)
    {
        String link = "https://api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&appid="+key;
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            if(connection.getResponseCode() == 200)
            {
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (connection.getInputStream())));

                Gson gson = new Gson();
                currentWeather = gson.fromJson(br, CurrentWeather.class);
                connection.disconnect();
            }
        }catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
