package com.example.uma.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.uma.model.Role;


public interface RoleRepository extends MongoRepository<Role,String>{
	Role findByRoleName(String roleName);
}
