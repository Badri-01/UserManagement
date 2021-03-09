package com.example.uma.daos;

import java.util.List;

import com.example.uma.models.User;

public interface UserDao {
	void addUser(User user);

	List<User> getAllUsers();

	User removeUser(String username);

	User getByUsername(String username);

}
