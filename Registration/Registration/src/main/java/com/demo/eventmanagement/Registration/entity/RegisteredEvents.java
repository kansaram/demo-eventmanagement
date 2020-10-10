package com.demo.eventmanagement.Registration.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class RegisteredEvents {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull(message="date has to be selected")
	@ApiModelProperty(notes="date of registered event")
	private Date date;
	
	@NotNull
	@ApiModelProperty(notes="Topic to be discussed during the event")
	String eventTopic;
	
	public RegisteredEvents() {
		// TODO Auto-generated constructor stub
	}

	public RegisteredEvents(Long id, @NotNull(message = "date has to be selected") Date date,
			@NotNull String eventTopic) {
		super();
		this.id = id;
		this.date = date;
		this.eventTopic = eventTopic;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEventTopic() {
		return eventTopic;
	}

	public void setEventTopic(String eventTopic) {
		this.eventTopic = eventTopic;
	}
	
	@Override
	public String toString() {
		return String.format("Registered event date and topic [date=%s, topic=%s ]", getDate(), getEventTopic());
	
	}

}
