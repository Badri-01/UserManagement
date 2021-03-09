package com.example.uma.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "roles")
public class Role {
	@Id
	private String roleId;
	private String roleName;
	private String roleStatus;
	
}
