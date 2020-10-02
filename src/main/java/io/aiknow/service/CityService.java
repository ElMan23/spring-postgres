package io.aiknow.service;

import java.util.List;

import io.aiknow.model.City;
import io.aiknow.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService implements ICityService {

    @Autowired
    private CityRepository repository;

    @Override
    public List<City> findAll() {

        var cities = (List<City>) repository.findAll();

        return cities;
    }

    @Override
    public City readCity(Long cityId) {

        City city = repository.findById(cityId).get();
        return city;
    }

    @Override
    public void createCity(City city) {

        repository.save(city);
    }

    @Override
    public void updateCity(Long cityId, String name, Integer population) {

        City city = repository.findById(cityId).get();
        city.setName(name);
        city.setPopulation(population);
        repository.save(city);
    }

    @Override
    public void deleteCity(Long cityId) {

        repository.deleteById(cityId);
    }
}