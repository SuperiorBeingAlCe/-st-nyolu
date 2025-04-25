package com.example.futergoal.controller.abstracts;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.futergoal.entities.City;


public interface CityController {

	 public List<City> getCitiesByCountry(@PathVariable Long countryId);
}
