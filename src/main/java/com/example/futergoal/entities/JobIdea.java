package com.example.futergoal.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_idea")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobIdea {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "job_idea_id")
	private Long id;
	
	 @Column(name = "title", nullable = false)
	    private String title;

	    @Column(name = "description", columnDefinition = "TEXT")
	    private String description;

	    @Column(name = "budget", nullable = false)
	    private BigDecimal budget;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "difficulty", nullable = false)
	    private JobDifficulty difficulty;


	    @Column(name = "created_at", nullable = false, updatable = false)
	    private LocalDateTime createdAt = LocalDateTime.now();

	    @Column(name = "location")
	    private String location;
	    
	    
	    
	    @Column(name = "updated_at")
	    private LocalDateTime updatedAt;
	    
	    public enum JobDifficulty {
	        EASY, NORMAL, HARD, IMPOSSIBLE
	    }
	}

