package com.example.futergoal.service.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.futergoal.dto.DtoLoginRequest;
import com.example.futergoal.security.JwtUtil;
import com.example.futergoal.service.abstracts.AuthService;

public class AuthServiceImpl implements AuthService{
	 @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private JwtUtil jwtUtils;

	@Override
	 public String authenticateAndGenerateToken(DtoLoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
            )
        );
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return jwtUtils.generateToken(userDetails.getUsername());
    }
	 
	 
}
