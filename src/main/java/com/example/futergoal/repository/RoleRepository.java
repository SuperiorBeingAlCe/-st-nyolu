package com.example.futergoal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.futergoal.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	
	 Optional<Role> findByName(@Param("name") String name);
	
}
