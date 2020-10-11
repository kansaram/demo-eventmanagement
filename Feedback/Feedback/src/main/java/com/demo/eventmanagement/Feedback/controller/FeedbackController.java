package com.demo.eventmanagement.Feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.eventmanagement.Feedback.event.Feedback;
import com.demo.eventmanagement.Feedback.event.User;
import com.demo.eventmanagement.Feedback.repository.UserRepository;

@RestController
public class FeedbackController {

	
	  @Autowired 
	  private UserRepository userRepository;
	 
	
	@PostMapping("/userFeedback/{user}/")
	public void getFeedback(@RequestBody User user) {
	System.out.println("Inside Controller");	
	  userRepository.save(user);
		
	}
}
