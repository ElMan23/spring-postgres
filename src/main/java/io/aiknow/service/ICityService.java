package io.aiknow.service;


import io.aiknow.model.City;

import java.util.List;

public interface ICityService {

    List<City> findAll();

    City readCity(Long cityId);

    void createCity(City city);

    void updateCity(Long cityId, String name, Integer population);

    void deleteCity(Long cityId);
    
}