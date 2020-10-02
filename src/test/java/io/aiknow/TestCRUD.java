package io.aiknow;

import io.aiknow.model.City;
import io.aiknow.service.CityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestCRUD {

    @Autowired
    CityService cityService = new CityService();

    @Test
    public void testCreate() {

        City city = new City(3l, "Milano", 1397457);
        cityService.createCity(city);
    }

    @Test
    public void testRead() {

        City city = cityService.readCity(2l);
        System.out.println(city);
    }

    @Test
    public void testUpdate() {

        cityService.updateCity(3l, "Bergamo", 200000);
    }

    @Test
    public void testDelete() {

        cityService.deleteCity(3l);
    }
}
