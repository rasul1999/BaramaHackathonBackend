package com.hackathon.error;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(String message) {
		super(message);
	}
}
