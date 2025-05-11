package com.example.futergoal.service.abstracts;

import com.example.futergoal.dto.DtoLoginRequest;

public interface AuthService {
	
	  public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException ; 
}
