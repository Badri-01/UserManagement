package com.example.uma.daos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.uma.models.User;

public interface UserRepository extends MongoRepository<User,String>{
	User findByUsername(String username);
}
