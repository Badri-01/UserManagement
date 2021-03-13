package com.example.uma.exception.role;

@SuppressWarnings("serial")
public class RoleAlreadyExistsException extends Exception {

	public RoleAlreadyExistsException(String role) {
		super(role);
	}
	
}
