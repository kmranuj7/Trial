package com.userservice.services;

import java.util.List;

import com.userservice.entities.User;

public interface UserService {
	
	//create
	User saveUser(User user);
	
	//getAllUser
	List<User> getAllUser();
	
	//get single user of a given userId
	User getUser(String userId);

}
