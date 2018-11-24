package com.hackathon.exception.handler;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hackathon.error.UserErrorRest;
import com.hackathon.error.UserNotFoundException;

@ControllerAdvice
public class UserExceptionHandlerController {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<UserErrorRest> handleUserError(UserNotFoundException ex){
		UserErrorRest userError = new UserErrorRest(ex.getMessage(),HttpStatus.NOT_FOUND.toString(),new Date());
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity<UserErrorRest>(userError,headers,HttpStatus.NOT_FOUND);
	}
}
