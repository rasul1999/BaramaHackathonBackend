package com.hackathon.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.model.User;
import com.hackathon.repository.UserRepository;

@RestController
public class SimpleRestController {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping(value="/user")
	public Iterable<User> user() {
		return userRepo.findAll();
	}
	
	
}
