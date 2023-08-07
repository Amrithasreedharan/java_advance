package com.microservice.restmicro.service;

import com.microservice.restmicro.beans.Country;
import com.microservice.restmicro.controllers.AddResponse;
import com.microservice.restmicro.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Component
@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountryId(int id) {
        List<Country> countries = countryRepository.findAll();
        Country country = null;
        for (Country con : countries) {
            if (con.getId() == id)
                country = con;
        }
        return country;
    }

    public Country getCountryByName(String countryName) {
        List<Country> countries = countryRepository.findAll();
        Country country = null;
        for (Country con : countries) {
            if (con.getCountryname().equalsIgnoreCase(countryName))
                country = con;
        }
        return country;
    }

    public Country addCountry(
            Country country) {
        country.setId(getMaxId());
        countryRepository.save(country);
        return country;
    }

    public Country updateCountry(Country country) {
        countryRepository.save(country);
        return country;
    }

    public void deleteCountry(Country country) {
        countryRepository.delete(country);
    }

    //utility method
    public int getMaxId() {
        return countryRepository.findAll().size() + 1;
    }


}
