package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    /**
     * Create a mock list for my cityList
     * @return
     */
    public CustomList MockCityList() {
        list = new CustomList(null,, new ArrayList<>());
        return list;
    }

    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Ciry", "PR"));
        assertEquals(list.getCount(), listSize + 1);
    }
}
