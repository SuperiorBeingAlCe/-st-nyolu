package com.example.futergoal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.futergoal.entities.Title;

@Repository
public interface TitleRepository extends JpaRepository<Title, Long>{
	 Optional<Title> findByName(@Param("name") String name);
}
