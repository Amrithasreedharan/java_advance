package com.microservice.restmicro.repositories;

import com.microservice.restmicro.beans.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Integer> {

}
