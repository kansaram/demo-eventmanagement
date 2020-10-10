package com.demo.eventmanagement.Event.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

@ApiModel(description="All details about the user.")
@Entity
public class Event {
	
	@Id
	@GeneratedValue
	private Long id;

	@Size(min=2, message="event should have atleast 2 characters")
	@ApiModelProperty(notes="subject to be discussed")
	private String subject;
	
	@Size(min=2, message="event stream should be descriptive")
	@ApiModelProperty(notes="stream associated with subject")
	private String stream;
	
	@OneToOne(mappedBy="event")
	private EventDetails details;
	
	@OneToOne(mappedBy="event")
	private RegisteredEvent registeredEvent;

	public Event() {
		// TODO Auto-generated constructor stub
	}
	
	public Event(Long id, String subject, String stream) {
		super();
		this.id = id;
		this.subject = subject;
		this.stream = stream;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public EventDetails getDetails() {
		return details;
	}

	public void setDetails(EventDetails details) {
		this.details = details;
	}

	public RegisteredEvent getRegisteredEvent() {
		return registeredEvent;
	}

	public void setRegisteredEvent(RegisteredEvent registeredEvent) {
		this.registeredEvent = registeredEvent;
	}

	@Override
	public String toString() {
		return String.format("Event [subject=%s , stream=%s]", getSubject(), getStream());
	
	}

	

}
