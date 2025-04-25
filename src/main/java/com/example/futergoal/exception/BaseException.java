package com.example.futergoal.exception;

public class BaseException extends RuntimeException{

	public BaseException() {
		
	}
	
public BaseException(ErrorMessage errorMessage) {
		super(errorMessage.prepareErrorMessage());
	}
}
