package com.hackathon.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistrationRestController {

	@PostMapping("/send")
	public ResponseEntity<String> registrationPage(){
		return ResponseEntity.ok().body("Good!");
	}
}
