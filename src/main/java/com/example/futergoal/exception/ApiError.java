package com.example.futergoal.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
 @NoArgsConstructor
public class ApiError<T> {

	private String id;
	
	private Date errorTime;
	
	private T errors;  
}

