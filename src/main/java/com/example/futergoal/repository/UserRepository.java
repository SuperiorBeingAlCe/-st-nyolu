package com.example.futergoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.futergoal.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
 User findByUsername(String username);
	
	
}
