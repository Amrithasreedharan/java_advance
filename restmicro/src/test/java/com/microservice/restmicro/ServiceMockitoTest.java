package com.microservice.restmicro;

import com.microservice.restmicro.beans.Country;
import com.microservice.restmicro.repositories.CountryRepository;
import com.microservice.restmicro.service.CountryService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {ServiceMockitoTest.class})
public class ServiceMockitoTest {

    @Mock
    CountryRepository countryRepository;
    @InjectMocks
    CountryService countryService;
    public List<Country> mycountries;
    //testing first method.
    @Test
    @Order(1)
    public void  test_getAllCountries(){
        List<Country> mycountries = new ArrayList<>();
        mycountries.add((new Country(1,"india","Delhi")));
        mycountries.add((new Country(2,"new zealand","wellington")));
        mycountries.add((new Country(3,"sri lanka","colombo")));
        when(countryRepository.findAll()).thenReturn(mycountries); // mocking statement.
       assertEquals(3,countryService.getAllCountries().size());

    }
    @Test
    @Order(2)
    public  void test_getCountryByID(){
        List<Country> mycountries = new ArrayList<>();
        mycountries.add((new Country(1,"india","Delhi")));
        mycountries.add((new Country(2,"new zealand","wellington")));
        mycountries.add((new Country(3,"sri lanka","colombo")));
        int countryID = 2;
        when(countryRepository.findAll()).thenReturn(mycountries);
        assertEquals(2,countryService.getCountryId(countryID).getId());

    }
    @Test
    @Order(3)
    public  void test_getCountryByName(){
        List<Country> mycountries = new ArrayList<>();
        mycountries.add((new Country(1,"india","Delhi")));
        mycountries.add((new Country(2,"new zealand","wellington")));
        mycountries.add((new Country(3,"sri lanka","colombo")));
        String countryName = "india";
        when(countryRepository.findAll()).thenReturn(mycountries);
        assertEquals("india",countryService.getCountryByName(countryName).getCountryname());

    }
    @Test
    @Order(4)
    public  void test_addCountry(){
        Country country = new Country(4,"Germany","Berlin");
        countryService.addCountry(country);
        when(countryRepository.save(country)).thenReturn(country);
        assertEquals(country,countryService.addCountry(country));

    }
    @Test
    @Order(5)
    public  void test_updateCountry(){
        Country country = new Country(4,"Germany","Berlin");
        when(countryRepository.save(country)).thenReturn(country);
        assertEquals(country,countryService.updateCountry(country));

    }
    @Test
    @Order(6)
    public  void test_deleteCountry(){
        Country country = new Country(4,"Germany","Berlin");
        countryService.deleteCountry(country);
        verify(countryRepository, times(1)).delete(country); // mocking along with assrertion


    }


}
