package com.example.futergoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.futergoal.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

	List<City> findByCountryId(Long id);
	
}
