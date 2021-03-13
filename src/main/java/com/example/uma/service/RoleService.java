package com.example.uma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uma.dao.RoleRepository;
import com.example.uma.model.Role;

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

	public Role removeRole(String roleName) {
		Role role = roleRepository.findByRoleName(roleName);
		if(role==null)
			return null;
		roleRepository.delete(role);
		return role;
	}

	public Role getById(String roleName) {
		return roleRepository.findByRoleName(roleName);
	}
}

