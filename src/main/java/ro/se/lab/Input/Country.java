package ro.se.lab.Input;

import java.util.ArrayList;

public class Country
{
    public String CountryName;
    public ArrayList<String> cities;

    public Country(String countryName)
    {
        CountryName = countryName;
        cities = new ArrayList<>();
    }

}
