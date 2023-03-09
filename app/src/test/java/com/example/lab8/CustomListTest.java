package com.example.lab8;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    /**
     * Create a mock list for my cityList
     * @return
     */
    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Ciry", "PR")); // yes the ciry and pr are intentional
        assertEquals(list.getCount(), listSize + 1);
    }

    @Test
    void testHasCity() {
        list = MockCityList();
        City city = new City("Charlottetown", "PEI");
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    @Test
    void testDelete() {
        list = MockCityList();
        int listSize = list.getCount();
        City city = new City("Edmonton", "AB");
        assertEquals(list.getCount(), listSize); // nothing has happened
        list.addCity(city);
        assertEquals(list.getCount(), listSize + 1); // add one list
        list.delCity(city);
        assertEquals(list.getCount(), listSize); // return to original
        assertFalse(list.hasCity(city));
    }

    @Test
    void testDeleteException() {
        list = MockCityList();
        City city = new City("Edmonton", "AB");
        assertThrows(IllegalArgumentException.class, () -> {
            list.delCity(city); // edmonton not in list
        });
    }

    @Test
    void testCountCities() {
        list = MockCityList();
        assertEquals(1, list.countCities());
    }
}
