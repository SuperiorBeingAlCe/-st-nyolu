package com.example.futergoal.service.abstracts;

import org.springframework.security.core.userdetails.UserDetails;

public interface CustomUserDetailsService {
	
	public UserDetails loadUserByUsername(String username);
}
