package com.demo.eventmanagement.Users.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.eventmanagement.Users.entity.User;

@FeignClient(name="Event", url="localhost:8000")
public interface EventDetailServiceProxy {
	
	@GetMapping("/registeredEvent/{eventId}/")
	public User registeredEvent(@PathVariable Long eventId);
}