package com.example.uma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.uma.daos.UserDao;
import com.example.uma.models.User;

@Service
public class UserService {
	
	@Autowired
	private @Qualifier("userDao") UserDao userDao;
	
	public void addUser(User user) {
		userDao.addUser(user);
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public User removeUser(String username) {
		return userDao.removeUser(username);
	}

	public User getByUsername(String username) {
		return userDao.getByUsername(username);
	}
}
