package com.example.uma.service;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uma.dao.PrivilegeRepository;
import com.example.uma.dao.RoleRepository;
import com.example.uma.dao.UserRepository;
import com.example.uma.exception.privilege.RoleAlreadyAssignedException;
import com.example.uma.exception.role.RoleNotFoundException;
import com.example.uma.model.Privilege;
import com.example.uma.model.Role;
import com.example.uma.model.User;

@Service
public class PrivilegeService {
	@Autowired
	private PrivilegeRepository privilegeRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;

	public List<Privilege> getAllPrivileges() {
		return privilegeRepository.findAll();
	}

	public void addPrivilege(Privilege privilege) {
		privilegeRepository.insert(privilege);
	}

	public User updateRole(String username, @Valid Role role) throws RoleNotFoundException,RoleAlreadyAssignedException{
		User user=userRepository.findByUsername(username);
		Set<Role> roles=user.getRoles();
		Role dbrole=roleRepository.findByRoleName(role.getRoleName());
		if(dbrole==null) {
			throw new RoleNotFoundException(role.getRoleName());
		}
		if(roles.contains(dbrole)) {
			throw new RoleAlreadyAssignedException("User "+username+" already has "+role.getRoleName()+" role");
		}
		if(dbrole.getRoleStatus()=="Inactive") {
			dbrole.setRoleStatus("Active");
		}
		roles.add(dbrole);
		roleRepository.save(dbrole);
		user.setRoles(roles);
		return userRepository.save(user);
	}
	
	
}
