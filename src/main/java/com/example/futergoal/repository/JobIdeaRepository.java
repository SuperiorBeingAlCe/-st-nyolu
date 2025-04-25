package com.example.futergoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.futergoal.entities.JobIdea;

@Repository
public interface JobIdeaRepository extends JpaRepository<JobIdea, Long>{

}
