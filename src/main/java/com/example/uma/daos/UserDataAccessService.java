package com.example.uma.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.uma.models.User;

@Repository("userDao")
public class UserDataAccessService implements UserDao{
	
	@Autowired
	private MongoTemplate mongoTemplate;
	@Override
	public void addUser(User user) {
		mongoTemplate.insert(user,"users");
	}
	@Override
	public List<User> getAllUsers() {
		return mongoTemplate.findAll(User.class);
	}
	
	@Override
	public User removeUser(String username) {
		Query q=new Query();
		q.addCriteria(Criteria.where("username").is(username));
		return mongoTemplate.findAndRemove(q, User.class);
	}
	@Override
	public User getByUsername(String username) {
		Query q=new Query();
		q.addCriteria(Criteria.where("username").is(username));
		return mongoTemplate.findOne(q, User.class);
	}

}
