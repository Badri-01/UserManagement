package com.example.uma.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "privileges")
public class Privilege {
	@Id
	private String privilegeId;
    private ArrayList<Permission> permissions=new ArrayList<Permission>(); 
	private String resourceName;
	private String roleName;

	public Privilege(Collection<String> permissions,String resourceName,String roleName) {
		for(String permission:permissions)
			this.permissions.add(Permission.valueOf(permission));
		this.resourceName=resourceName;
		this.roleName=roleName;
	}

	public ArrayList<Permission> getPrivileges() {
		return permissions;
	}

	public String getResourceName() {
		return resourceName;
	}

	public String getRoleName() {
		return roleName;
	}
	
}
