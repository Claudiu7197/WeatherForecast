package ro.se.lab.Services.WeatherClasses;

import com.google.gson.annotations.SerializedName;

public class Coordinates
{
    @SerializedName("lon")
    public double longitude;
    @SerializedName("lat")
    public double latitude;
}
