package com.example.uma.models;

import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "privileges")
public class Privilege {
	@Id
	private String Id;
    private String name; 
    private Collection<Role> roles;
}
