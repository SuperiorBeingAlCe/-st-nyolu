package com.example.futergoal.controller.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.futergoal.controller.abstracts.CityController;
import com.example.futergoal.entities.City;
import com.example.futergoal.service.abstracts.CityService;

@RestController
@RequestMapping("/cities")
public class CityControllerImpl implements CityController{

	  @Autowired
	    private CityService cityService;

	@Override
	public List<City> getCitiesByCountry(Long countryId) {
		
		return cityService.getCitiesByCountry(countryId);
	}
	  
	  
	
}
