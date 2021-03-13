package com.example.uma.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.uma.model.User;

public interface UserRepository extends MongoRepository<User,String>{
	User findByUsername(String username);
}
