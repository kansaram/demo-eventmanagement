package com.demo.eventmanagement.Survey.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.eventmanagement.Survey.entity.User;

@FeignClient(name="Users", url="localhost:8002")
public interface FeedbackServiceProxy {
	
	@GetMapping("/user/event/{eventId}")
	public List<User> retrieveUsersByEventId(@PathVariable Long eventId);
}