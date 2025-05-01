package com.example.futergoal.service.abstracts;

import com.example.futergoal.dto.DtoLoginRequest;

public interface AuthService {
	
	 public String authenticateAndGenerateToken(DtoLoginRequest loginRequest); 
}
