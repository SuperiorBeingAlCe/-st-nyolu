package com.example.futergoal.controller.concretes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/test")
public class TestController {
	  @GetMapping("/all")
	    public String allAccess() {
	        return "Public Content.";
	    }
	    @GetMapping("/user")
	    public String userAccess() {
	        return "User Content.";
	    }
	}

