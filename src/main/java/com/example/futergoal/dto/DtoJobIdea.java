package com.example.futergoal.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoJobIdea {
	
	private String title;
    private BigDecimal budget;
    private String location;
    private String username;
	
	
}
