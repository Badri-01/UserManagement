package com.example.uma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.uma.daos.UserRepository;
import com.example.uma.models.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void addUser(User user) {
		userRepository.insert(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User removeUser(String username) {
		Query q=new Query();
		q.addCriteria(Criteria.where("username").is(username));
		User user=userRepository.findByUsername(username);
		if(user==null)
			return null;
		userRepository.delete(user);
		return user;
	}

	public User getByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public User updateUser(String username, User user) {
		User oldUser = userRepository.findByUsername(username);
		if(oldUser==null)
			return null;
		oldUser.update(user);
		userRepository.save(oldUser);
		return oldUser;
	}
}
