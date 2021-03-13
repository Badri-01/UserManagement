package com.example.uma.exception.user;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception{
	public UserNotFoundException(String username) {
		super(username);
	}
}
