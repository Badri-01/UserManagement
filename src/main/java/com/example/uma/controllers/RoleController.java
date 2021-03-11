package com.example.uma.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.uma.exceptions.RoleAlreadyExistsException;
import com.example.uma.exceptions.RoleNotFoundException;
import com.example.uma.models.Role;
import com.example.uma.services.RoleService;

@RequestMapping("/api/v1/role/")
@RestController	
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@GetMapping
	public List<Role> getAllRoles() {
		return roleService.getAllRoles();
	}
	
	@GetMapping(path = "{id}")
	public Role getByRoleId(@PathVariable("id") String id) throws RoleNotFoundException{
		Role role=roleService.getById(id);
		if(role!=null)
			return role;
		throw new RoleNotFoundException(id);
	}
	
	@PostMapping
	public @ResponseBody String createRole(@Valid @RequestBody Role role) throws RoleAlreadyExistsException{
		try {
			roleService.addRole(role);
		}
		catch(DuplicateKeyException ex) {
			//System.out.println(ex.getClass());
			throw new RoleAlreadyExistsException(role.getRoleName());
		}
		return role.getRoleName()+" role created";
	}
	
	@DeleteMapping(path = "{id}")
	public String deleteRole(@PathVariable("id") String id) throws RoleNotFoundException{
		Role role=roleService.removeRole(id);
		if(role!=null)
			return "Role "+role.getRoleName()+" deleted";
		throw new RoleNotFoundException(id);
	}
	
	@ExceptionHandler(RoleNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody String handleRoleNotFoundException(RoleNotFoundException ex)
	{
	  return "Role with id "+ex.getMessage()+" not found";
	}
	
	@ExceptionHandler(RoleAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody String handleRoleAlreadyExistsException(RoleAlreadyExistsException ex)
	{
	  return "Role "+ ex.getMessage()+" already exists";
	}
	
}
