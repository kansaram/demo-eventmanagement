package com.demo.eventmanagement.Event.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.eventmanagement.Event.entity.Event;
import com.demo.eventmanagement.Event.entity.EventDetails;
import com.demo.eventmanagement.Event.entity.RegisteredEvent;
import com.demo.eventmanagement.Event.repository.EventDetailRepository;
import com.demo.eventmanagement.Event.repository.EventsRepository;
import com.demo.eventmanagement.Event.repository.RegisteredEventRepository;

@RestController
public class EventController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EventsRepository event;
	
	@Autowired
	private EventDetailRepository eventDetail;
	
	@Autowired
	private RegisteredEventRepository registeredEvent;
	
	@GetMapping("/events/")
	public List<Event> retrieveAllEvents() {
		
		List<Event> events =   event.findAll();
		log.info("{}", events);
		
		return events;
	}

	@GetMapping("/event/{id}/eventDetail")
	public EventDetails retrievEventDetails(@PathVariable long id) {
		Optional<Event> eventOptional = event.findById(id);
		
		if(!eventOptional.isPresent()) {
//			throw new EventNotFoundException("id-"+ id);
		}
		log.info("{}", eventOptional.get().getDetails());
		
		return eventOptional.get().getDetails();

	}
	
	@GetMapping("/registeredEvents/")
	public List<RegisteredEvent> retrieveRegisteredEvents() {
		List<RegisteredEvent> registeredEventList = registeredEvent.findAll();
		
		log.info("{}", registeredEventList);
		
		return registeredEventList;

	}
	
	@GetMapping("/registeredEvent/{eventId}/")
	public RegisteredEvent registeredEvent(@PathVariable Long eventId) {
		
		Optional<Event> eventOptional  = event.findById(eventId);
		
		if(!eventOptional.isPresent()) {
//			throw new EventNotFoundException("id-"+ id);
		}
		
		RegisteredEvent regEvent = eventOptional.get().getRegisteredEvent();
		
		return  regEvent;
	}
	
	@PostMapping("/registeredEvent/{eventId}/date/{date}")
	public void registeredEvent(@PathVariable Long eventId, @PathVariable Date date) {
		
		Optional<Event> eventOptional  = event.findById(eventId);
		
		if(!eventOptional.isPresent()) {
//			throw new EventNotFoundException("id-"+ id);
		}
		EventDetails eventDetails = eventOptional.get().getDetails();

		RegisteredEvent regEvent = new RegisteredEvent(date, eventDetails.getEventDetails(),
				eventOptional.get().getSubject(),
				eventOptional.get().getStream());
		
		registeredEvent.save(regEvent);
		return;
	}

}
