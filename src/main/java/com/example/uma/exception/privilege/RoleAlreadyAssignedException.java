package com.example.uma.exception.privilege;

public class RoleAlreadyAssignedException extends Exception{

	private static final long serialVersionUID = 1L;
	public RoleAlreadyAssignedException(String message) {
		super(message);
	}

}
