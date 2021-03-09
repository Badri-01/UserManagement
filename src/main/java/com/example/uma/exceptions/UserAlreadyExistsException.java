package com.example.uma.exceptions;

@SuppressWarnings("serial")
public class UserAlreadyExistsException extends Exception {

	public UserAlreadyExistsException(String username) {
		super(username);
	}
	
}
