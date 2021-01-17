package ro.se.lab.Input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FileReadTest {

    @Test
    @DisplayName("read_file_test")
    void ReadFileTest()
    {
        mockStatic(FileRead.class);
        ArrayList<Entity> entities = new ArrayList<>();
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country("A"));
        countries.get(0).cities.add("City for A");
        when(FileRead.MakeCountryArray(entities)).thenReturn(countries);
        ArrayList<Country> test = FileRead.MakeCountryArray(entities);
        assertEquals(test, countries);
    }
}