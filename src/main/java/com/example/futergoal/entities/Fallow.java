package com.example.futergoal.entities;

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
@Table(name = "fallow")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fallow {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "fallow_id")
	private Long id;
	 
	 @ManyToOne
	    @JoinColumn(name = "follow_id", nullable = false)
	    private User follower;
	 
	 @ManyToOne
	    @JoinColumn(name = "following_id", nullable = false)
	    private User following;
	 
	 @Column(name = "created_at", nullable = false, updatable = false)
	    private LocalDateTime createdAt = LocalDateTime.now();
	 

	    @Enumerated(EnumType.STRING)
	    @Column(name = "status")
	    private FollowStatus status = FollowStatus.ACTIVE; 

	    public enum FollowStatus {
	        ACTIVE, BLOCKED, REQUESTED
	    }
	 
}
