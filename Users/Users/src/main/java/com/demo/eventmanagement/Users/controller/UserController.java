package com.demo.eventmanagement.Users.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.eventmanagement.Users.Repository.UserRepository;
import com.demo.eventmanagement.Users.entity.User;
import com.demo.eventmanagement.Users.service.SendEmailHelperService;


@RestController
public class UserController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EventDetailServiceProxy proxy;
	
	@Autowired
	private SendEmailHelperService sendEmailService;
	
	@GetMapping("/user")
	public List<User> retrieveAllUsers() {
		
		List<User> users =   userRepository.findAll();
		log.info("{}", users);
		
		return users;
	}
	
	@GetMapping("/user/event/{eventId}")
	public List<User> retrieveUsersByEventId(@PathVariable Long eventId) {
		
		User user = proxy.registeredEvent(eventId);
		
		List<User> users =   userRepository.findByEventId(user.getEventId());
		log.info("{}", users);
		
		return users;
	}
	
	@PostMapping("/sendEmail/event/{eventId}")
	public void sendEmail(@PathVariable Long eventId) {
		
		List<User> users = retrieveUsersByEventId(eventId);
		User user = proxy.registeredEvent(eventId);
		
		sendEmailService.sendMail(users,user.getEventDetails());
		return;
	}

	
	
}
