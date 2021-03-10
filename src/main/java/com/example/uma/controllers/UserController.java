package com.example.uma.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
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

import com.example.uma.exceptions.UserAlreadyExistsException;
import com.example.uma.exceptions.UserNotFoundException;
import com.example.uma.models.User;
import com.example.uma.services.UserService;

@RequestMapping("/api/v1/user/")
@RestController	
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping(path = "{username}")
	public User getByUsername(@PathVariable("username") String username) throws UserNotFoundException{
		User user=userService.getByUsername(username);
		if(user!=null)
			return user;
		throw new UserNotFoundException(username);
	}
	
	
	@PostMapping
	public @ResponseBody String createUser(@Valid @RequestBody User user) throws UserAlreadyExistsException{
		try {
			userService.addUser(user);
		}
		catch(Exception me) {
			throw new UserAlreadyExistsException(user.getUsername());
		}
		return "Signed up succesfully";
	}
	
	@PutMapping(path = "{username}")
	public @ResponseBody String updateUser(@PathVariable("username") String username, @Valid @RequestBody User user) throws UserNotFoundException{
		user=userService.updateUser(username,user);
		if(user!=null)
			return "User "+user.getUsername()+" account updated";
		throw new UserNotFoundException(username);
	}
	
	
	
	@DeleteMapping(path = "{username}")
	public String deleteUser(@PathVariable("username") String username) throws UserNotFoundException{
		User user=userService.removeUser(username);
		if(user!=null)
			return "User "+user.getUsername()+" account deleted";
		throw new UserNotFoundException(username);
	}
	
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody String handleUserNotFoundException(UserNotFoundException ex)
	{
	  return "Username "+ex.getMessage()+" not found";
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody String handleException(UserAlreadyExistsException ex)
	{
	  return "Username "+ ex.getMessage()+" already exists";
	}
}
