package com.example.futergoal.controller.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.futergoal.controller.abstracts.AuthController;
import com.example.futergoal.entities.User;
import com.example.futergoal.repository.UserRepository;
import com.example.futergoal.security.JwtUtil;
import com.example.futergoal.service.abstracts.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthControllerImpl implements AuthController{
	 @Autowired
	    AuthenticationManager authenticationManager;
	    @Autowired
	    AuthService authService;
	    @Autowired
	    PasswordEncoder encoder;
	    @Autowired
	    JwtUtil jwtUtils;
	    @Autowired
	    UserRepository userRepository;
	    
	    @PostMapping("/signin")
	    @Override
	    public String authenticateUser(@RequestBody User user) {
	    	  Authentication authentication = authenticationManager.authenticate(
	                  new UsernamePasswordAuthenticationToken(
	                          user.getUserName(),
	                          user.getPassword()
	                  )
	          );
	          UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	          return jwtUtils.generateToken(userDetails.getUsername());
	  
}}
