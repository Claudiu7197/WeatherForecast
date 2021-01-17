package ro.se.lab.Input;

import java.io.*;
import java.util.ArrayList;

public class FileRead
{
    private static String fileName = "input.txt";
    private static ArrayList<Entity> inputs = new ArrayList<>();
    public static ArrayList<Country> countries = new ArrayList<>();

    public static void Read()
    {
        try {
            File file = new File(fileName);
            file.createNewFile();
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean first = false;
            String line;
            while((line=bufferedReader.readLine()) != null)
            {
                if(!first)
                {
                    first = true;
                    continue;
                }
                inputs.add(new Entity(line));
            }
            bufferedReader.close();
            System.out.println(inputs.size());
            countries = MakeCountryArray(inputs);
            System.out.println(countries.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Country> MakeCountryArray(ArrayList<Entity> entities)
    {
        ArrayList<Country> result = new ArrayList<>();
        for (Entity e : entities)
        {
            String countryName = e.CountryCode;
            boolean exists = false;
            for(int i = 0; i<result.size(); i++)
            {
                if(result.get(i).CountryName.equals(countryName))
                {
                    exists = true;
                    result.get(i).cities.add(e.CityName);
                }
            }
            if(!exists)
            {
                result.add(new Country(countryName));
                int index = countries.size()-1;
                result.get(index).cities.add(e.CityName);
            }
        }
        return result;
    }
}
