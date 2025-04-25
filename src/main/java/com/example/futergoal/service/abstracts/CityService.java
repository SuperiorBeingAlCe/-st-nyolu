package com.example.futergoal.service.abstracts;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.futergoal.entities.City;

public interface CityService {
	
	 public List<City> getCitiesByCountry(@PathVariable Long countryId);
}
