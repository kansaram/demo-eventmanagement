package com.demo.eventmanagement.Registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.eventmanagement.Registration.entity.RegisteredUser;
import com.demo.eventmanagement.Registration.repository.UserRegisteredRepository;

@RestController
public class RegistrationController {

	@Autowired
	private UserRegisteredRepository regUserRepo;
	
	@PostMapping("/registeredUser/{user}")
	public void userRegistration(@RequestBody RegisteredUser user) {
		
		regUserRepo.save(user);
	}
	
}
