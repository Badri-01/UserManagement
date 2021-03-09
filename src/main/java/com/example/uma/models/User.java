package com.example.uma.models;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

	@Id
	private String userId;
	@Indexed(unique=true)
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private String password;
	private Set<Role> roles;
	
	public User(String username, String firstName, String lastName,@NotNull String email, String mobile, String password,
			Set<Role> roles) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getMobile() {
		return mobile;
	}

	public String getPassword() {
		return "*******";
	}

	public Set<Role> getRoles() {
		return roles;
	}
	

}
