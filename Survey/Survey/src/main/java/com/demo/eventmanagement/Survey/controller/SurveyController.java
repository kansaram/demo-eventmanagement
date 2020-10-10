package com.demo.eventmanagement.Survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.eventmanagement.Survey.Service.SendEmailHelperService;
import com.demo.eventmanagement.Survey.entity.Material;
import com.demo.eventmanagement.Survey.entity.QuestionBank;
import com.demo.eventmanagement.Survey.entity.User;
import com.demo.eventmanagement.Survey.repository.MaterialRepository;

@RestController
public class SurveyController {

	@Autowired
	private FeedbackServiceProxy proxy;
	
	@Autowired
	private SendEmailHelperService sendEmailService;
	
	@Autowired
	private MaterialRepository materialRepository;
	
	@PostMapping("/sendEmail/user/feedback/event/{eventId}/topic/{topic}")
	public void sendSurveyEmail(@PathVariable Long eventId,@PathVariable String topic) {
		
		List<User> users = proxy.retrieveUsersByEventId(eventId);
		Material material = getMaterial(topic);
		
		sendEmailService.sendMail(users, new QuestionBank(), material);
		return;
	}
	
	@GetMapping("material/topic/{topic}")
	public Material getMaterial(@PathVariable String topic){
		
		return materialRepository.getByTopic(topic);
	}
}
