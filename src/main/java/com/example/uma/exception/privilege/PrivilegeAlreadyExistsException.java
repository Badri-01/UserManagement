package com.example.uma.exception.privilege;

@SuppressWarnings("serial")
public class PrivilegeAlreadyExistsException extends Exception{

	public PrivilegeAlreadyExistsException(String privilegeName) {
		super(privilegeName);
	}
	
}
