package com.example.futergoal.controller.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.futergoal.controller.abstracts.AuthController;
import com.example.futergoal.dto.DtoLoginRequest;
import com.example.futergoal.security.JwtUtil;
import com.example.futergoal.service.abstracts.AuthService;

@RestController
@RequestMapping("/rest/api/auth")
public class AuthControllerImpl implements AuthController{
	 @Autowired
	    AuthenticationManager authenticationManager;
	    @Autowired
	    AuthService authService;
	    @Autowired
	    PasswordEncoder encoder;
	    @Autowired
	    JwtUtil jwtUtils;
	    
	    @PostMapping("/signin")
	    public String authenticateUser(@RequestBody DtoLoginRequest loginRequest) {
	    	  return authService.authenticateAndGenerateToken(loginRequest);}
	    
	  
}
