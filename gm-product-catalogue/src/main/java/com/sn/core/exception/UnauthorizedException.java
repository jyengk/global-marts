package com.sn.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.UNAUTHORIZED, reason="Unauthorized to access resource")
public class UnauthorizedException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public UnauthorizedException(){
		super();
	}
	
	public UnauthorizedException(String message){
		super(message);
	}

}
