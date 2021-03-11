package com.example.uma.exceptions;

@SuppressWarnings("serial")
public class RoleNotFoundException extends Exception{
	public RoleNotFoundException(String id) {
		super(id);
	}
}
