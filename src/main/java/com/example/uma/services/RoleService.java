package com.example.uma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uma.daos.RoleRepository;
import com.example.uma.models.Role;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public void addRole(Role role) {
		roleRepository.insert(role);
	}

	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	public Role removeRole(String roleId) {
		Role role = roleRepository.findByRoleId(roleId);
		if(role==null)
			return null;
		roleRepository.delete(role);
		return role;
	}

	public Role getById(String roleId) {
		return roleRepository.findByRoleId(roleId);
	}
}

