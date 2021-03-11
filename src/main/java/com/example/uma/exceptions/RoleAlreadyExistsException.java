package com.example.uma.exceptions;

@SuppressWarnings("serial")
public class RoleAlreadyExistsException extends Exception {

	public RoleAlreadyExistsException(String role) {
		super(role);
	}
	
}
