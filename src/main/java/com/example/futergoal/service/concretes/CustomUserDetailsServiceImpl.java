package com.example.futergoal.service.concretes;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.futergoal.entities.User;
import com.example.futergoal.repository.UserRepository;
import com.example.futergoal.service.abstracts.CustomUserDetailsService;

public class CustomUserDetailsServiceImpl implements CustomUserDetailsService{
	 @Autowired
	    private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User user = userRepository.findByUsername(username);
		if (user == null) {
            throw new UsernameNotFoundException("User Not Found with username: " + username);
        }
		return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassword(),
                Collections.emptyList()
        );
	}
	 
	 
}
