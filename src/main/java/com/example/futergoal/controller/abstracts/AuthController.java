package com.example.futergoal.controller.abstracts;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.futergoal.entities.User;

public interface AuthController {
	
	public String authenticateUser(@RequestBody User user);
	
	 public String registerUser(@RequestBody User user);
}
