package com.example.uma.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "resources")
public class Resource {
	@Id
	private String resourceId;
	private String resourceName;
	
	public Resource(String resourceName) {
		this.resourceName=resourceName;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	
}
