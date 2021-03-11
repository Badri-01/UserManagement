package com.example.uma.daos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.uma.models.Role;


public interface RoleRepository extends MongoRepository<Role,String>{
	Role findByRoleId(String roleId);
}
