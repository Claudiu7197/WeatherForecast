package ro.se.lab.Input;

public class Entity
{
    public String ID;
    public String CityName;
    public String CountryCode;
    public double Latitude;
    public double Longitude;

    public Entity(String line)
    {
        String[] array = line.split(" ");
        ID = array[0];
        CityName = array[1];
        try {
            Latitude = Double.parseDouble(array[2]);
            Longitude = Double.parseDouble(array[3]);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        CountryCode = array[4];
    }
}
