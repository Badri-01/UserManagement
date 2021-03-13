package com.example.uma.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.uma.model.Privilege;

public interface PrivilegeRepository extends MongoRepository<Privilege,String>{
	Privilege findByRoleNameAndResourceName(String roleName,String resourceName);
}
