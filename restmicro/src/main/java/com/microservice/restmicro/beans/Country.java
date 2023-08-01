package com.microservice.restmicro.beans;

public class Country {
    int id;
    String countryName;
    String countryCapital;
    public Country(int id, String countryname, String countryCapital) {
        this.id = id;
        this.countryName = countryname;
        this.countryCapital = countryCapital;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryname() {
        return countryName;
    }

    public void setCountryname(String countryname) {
        this.countryName = countryname;
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public void setCountryCapital(String countryCapital) {
        this.countryCapital = countryCapital;
    }


}
