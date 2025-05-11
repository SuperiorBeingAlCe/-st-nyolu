package com.example.futergoal.service.concretes;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.futergoal.entities.User;
import com.example.futergoal.repository.UserRepository;
import com.example.futergoal.service.abstracts.AuthService;

@Service
public class AuthServiceImpl implements AuthService{
	

	    
	    @Autowired
	    private UserRepository userRepository;
	    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        
        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole().getName()))
        );
    }
	 
	 
}

	
	
	
