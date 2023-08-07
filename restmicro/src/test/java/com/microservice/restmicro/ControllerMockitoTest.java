package com.microservice.restmicro;

import com.microservice.restmicro.beans.Country;
import com.microservice.restmicro.controllers.CountryController;
import com.microservice.restmicro.repositories.CountryRepository;
import com.microservice.restmicro.service.CountryService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes ={ControllerMockitoTest.class})
public class ControllerMockitoTest {
    @Mock
    CountryService countryService;
    @InjectMocks
    CountryController countryController;
    List<Country> mycountries;
    Country country;
    @Test
    @Order(1)
    public void  test_getAllCountries() {
        List<Country> mycountries = new ArrayList<>();
        mycountries.add((new Country(1, "india", "Delhi")));
        mycountries.add((new Country(2, "new zealand", "wellington")));
        mycountries.add((new Country(3, "sri lanka", "colombo")));
        when(countryService.getAllCountries()).thenReturn(mycountries); // mocking
        ResponseEntity<List<Country>> res = countryController.getCountries();
        assertEquals(HttpStatus.FOUND,res.getStatusCode());
        assertEquals(3,res.getBody().size());

    }
    @Test
    @Order(2)
    public void  test_getCountrybyID() {
        country = new Country(2, "USA", "Washington");
        int countryID = 2;
        when(countryService.getCountryId(countryID)).thenReturn(country); // mocking
        ResponseEntity<Country> res = countryController.getCountryById(countryID);
        assertEquals(HttpStatus.FOUND,res.getStatusCode());
        assertEquals(countryID,res.getBody().getId());
    }




}

