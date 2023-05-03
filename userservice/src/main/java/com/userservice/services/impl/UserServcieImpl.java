package com.userservice.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.entities.User;
import com.userservice.exceptions.ResourceNotFoundException;
import com.userservice.repository.UserRepository;
import com.userservice.services.UserService;


@Service
public class UserServcieImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public User saveUser(User user) {
		//generate unique userId
		String randomUserId=UUID.randomUUID().toString();
		user.setUserId(randomUserId);
	return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		return userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id is not found in server ") );
	}
	

}
