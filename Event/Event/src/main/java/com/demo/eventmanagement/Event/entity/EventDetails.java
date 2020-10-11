package com.demo.eventmanagement.Event.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="All Event details")
@Entity
public class EventDetails {
	
	@Id
	@GeneratedValue
	private Integer id;

	@Size(min=2, message="event detail should have atleast 2 characters")
	@ApiModelProperty(notes="event detail related to subject")
	private String eventDetails;
	
	@OneToOne(fetch=FetchType.LAZY)
    @JsonIgnore
	private Event event;
	
	public EventDetails() {
		// TODO Auto-generated constructor stub
	}

	public EventDetails(Integer id,
			@Size(min = 2, message = "event detail should have atleast 2 characters") String eventDetails, Event event) {
		super();
		this.id = id;
		this.eventDetails = eventDetails;
		this.event = event;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEventDetails() {
		return eventDetails;
	}

	public void setEventDetails(String eventDetails) {
		this.eventDetails = eventDetails;
	}
	
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return String.format("Event Detailsx [eventDetails=%s ]", getEventDetails() );
	
	}
}
