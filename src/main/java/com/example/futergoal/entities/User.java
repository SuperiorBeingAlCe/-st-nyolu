package com.example.futergoal.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_name", nullable = false)
	private String userName;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "email", nullable = false, unique = true)
	@Email
	@NotNull
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	
	
	@Column(name = "signature")
	private String signature;

	@Column(name = "detail" )
	private String detail;

	
	@Column(name = "reliance", columnDefinition = "integer default 50")
	private Integer reliance;
	
	@Column(name = "points", columnDefinition = "integer default 0")
	private Integer points;

	@Column(name = "maxpoint", columnDefinition = "integer default 25")
	private Integer maxPoint;

	@Column(name = "level", columnDefinition = "integer default 1")
	private Integer level;

	
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
	    name = "user_titles",
	    joinColumns = @JoinColumn(name = "user_id"),
	    inverseJoinColumns = @JoinColumn(name = "title_id")
	)
	private List<Title> titles = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "selected_title_id")
	private Title title;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@ToString.Exclude
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<JobIdea> jobIdeas = new ArrayList<>();
	
	
}
