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
                System.out.println(line);
                inputs.add(new Entity(line));
            }
            bufferedReader.close();
            System.out.println(inputs.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
