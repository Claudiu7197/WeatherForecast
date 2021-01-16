package ro.se.lab.Services.WeatherClasses;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main
{
    public double temp;
    public double feels_like;
    public double temp_min;
    public double temp_max;
    public double pressure;
    public int humidity;

    public enum TEMP_TYPE
    {
        TEMP, REALFEEL, TEMP_MIN, TEMP_MAX
    }


    public String ConvertToCelsius(TEMP_TYPE type)
    {
        double value = 0;
        switch (type)
        {
            case TEMP -> value = temp;
            case REALFEEL -> value = feels_like;
            case TEMP_MAX -> value = temp_max;
            case TEMP_MIN -> value = temp_min;
        }
        double result = value - 273.15F;
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.DOWN);
        return df.format(result);
    }
}
