package com.example.futergoal.service.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.futergoal.entities.City;
import com.example.futergoal.repository.CityRepository;
import com.example.futergoal.service.abstracts.CityService;

@Service
public class CityServiceImpl implements CityService{

	@Autowired
	private CityRepository cityRepository;
	
	@Override
	public List<City> getCitiesByCountry(Long countryId) {
		
		return cityRepository.findByCountryId(countryId);
	}

}
