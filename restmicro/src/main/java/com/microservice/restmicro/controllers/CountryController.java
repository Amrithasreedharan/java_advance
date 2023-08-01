package com.microservice.restmicro.controllers;

import com.microservice.restmicro.beans.Country;
import com.microservice.restmicro.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {
     @Autowired
     CountryService countryService;
     //http://localhost:8080/getcountries
     @GetMapping("/getcountries")
     public List getCountries(){
        return countryService.getAllCountries();
     }
     //http://localhost:8080/getcountries/1
    @GetMapping("/getcountries/{id}")
    public Country getCountryById(@PathVariable(value = "id")int id){
        return countryService.getCountryId(id);
    }

    //http://localhost:8080/getcountries/countryname?name=India
    @GetMapping("/getcountries/countryname{id}")
    public Country getCountryByName(@RequestParam(value = "name")String countryname){
        return countryService.getCountryByName(countryname);
    }
    @PostMapping("/addcountry")
    public  Country addCountry(@RequestBody Country country){
         return countryService.addCountry(country);
    }
    //http://localhost:8080/updatecountry
    @PutMapping("/updatecountry")
    public  Country updateCountry(@RequestBody Country country){
        return countryService.updateCountry(country);
    }
    @DeleteMapping("/deletecountry/{id}")
    public AddResponse updateCountry(@PathVariable(value = "id")int id){
            return countryService.deleteCountry(id);
    }


}
