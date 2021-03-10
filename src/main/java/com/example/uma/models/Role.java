package com.example.uma.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "roles")
public class Role {
	@Id
	private String roleId;
	private String roleName;
	private String roleStatus;
	
	public Role(String roleName, String roleStatus) {
		this.roleName = roleName;
		this.roleStatus = roleStatus;
	}
	public String getRoleId() {
		return roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public String getRoleStatus() {
		return roleStatus;
	}
	
}
