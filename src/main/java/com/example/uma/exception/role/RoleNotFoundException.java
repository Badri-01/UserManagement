package com.example.uma.exception.role;

@SuppressWarnings("serial")
public class RoleNotFoundException extends Exception{
	public RoleNotFoundException(String name) {
		super(name);
	}
}
