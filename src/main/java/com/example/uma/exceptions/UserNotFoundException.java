package com.example.uma.exceptions;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception{
	public UserNotFoundException(String username) {
		super(username);
	}
}
