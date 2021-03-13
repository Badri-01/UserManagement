package com.example.uma.model;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
public class Role {
	@Id
	private String roleId;
	@Indexed(unique=true)
	private String roleName;
	
	//@DBRef
	//private Collection<Privilege> privileges;
	
	private String roleStatus;
	
	public Role(String roleName,String roleStatus) {
		this.roleName = roleName;
		this.roleStatus=roleStatus;
		//this.privileges=null;
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

	public void setRoleStatus(String status) {
		this.roleStatus=status;
	}
	
}
