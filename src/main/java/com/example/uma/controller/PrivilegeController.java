package com.example.uma.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.uma.exception.privilege.PrivilegeAlreadyExistsException;
import com.example.uma.exception.privilege.RoleAlreadyAssignedException;
import com.example.uma.exception.role.RoleNotFoundException;
import com.example.uma.exception.user.UserNotFoundException;
import com.example.uma.model.Privilege;
import com.example.uma.model.Role;
import com.example.uma.model.User;
import com.example.uma.service.PrivilegeService;

@RequestMapping("/api/v1/privilege/")
@RestController	
public class PrivilegeController {
	@Autowired
	private PrivilegeService privilegeService;
	
	
	@GetMapping
	public List<Privilege> getAllPrivileges() {
		return privilegeService.getAllPrivileges();
	}
	
	@PutMapping("{username}/role/")
	public @ResponseBody String updateRole(@PathVariable("username") String username, @Valid @RequestBody Role role) 
			throws RoleNotFoundException,RoleAlreadyAssignedException,UserNotFoundException{
		User user=privilegeService.updateRole(username,role);
		if(user!=null)
			return "User "+user.getUsername()+" has new role "+role.getRoleName()+" added";
		throw new UserNotFoundException(username);
	}
	
	//Define new permissions to a role for all services.
	
	@PostMapping("role/{roleName}/")
	public @ResponseBody String newPrivilegesForRole(@PathVariable("roleName") String roleName,@Valid @RequestBody Privilege privilege) throws PrivilegeAlreadyExistsException{
		privilegeService.newPrivilegesForRole(roleName,privilege);
		return "Role "+privilege.getRoleName()+" now has "+privilege.getPrivileges().toString()+"permissions for all services";
	}
	
	@ExceptionHandler(PrivilegeAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody String handlePrivilegeAlreadyExistsException(PrivilegeAlreadyExistsException ex)
	{
	  return "Privilege "+ ex.getMessage()+" already exists";
	}
	
	@ExceptionHandler(RoleNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody String handleRoleNotFoundException(RoleNotFoundException ex)
	{
	  return "Role "+ex.getMessage()+" not found";
	}
	
	@ExceptionHandler(RoleAlreadyAssignedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody String handleRoleAlreadyAssignedException(RoleAlreadyAssignedException ex)
	{
	  return ex.getMessage();
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody String handleUserNotFoundException(UserNotFoundException ex)
	{
	  return "Username "+ex.getMessage()+" not found";
	}
}
