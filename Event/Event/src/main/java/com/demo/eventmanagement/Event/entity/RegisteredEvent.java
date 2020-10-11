package com.demo.eventmanagement.Event.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="RegisteredEvent")
@Entity
public class RegisteredEvent {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull(message="date has to be selected")
	@ApiModelProperty(notes="date of registered event")
	private Date date;
	
	@NotNull
	@ApiModelProperty(notes="registered the event")
	@OneToOne(fetch=FetchType.LAZY)
	private Event event;
	
	@Size(min=2, message="event detail should have atleast 2 characters")
	@ApiModelProperty(notes="event detail related to subject")
	private String eventDetails;
	
	@Size(min=2, message="event should have atleast 2 characters")
	@ApiModelProperty(notes="subject to be discussed")
	private String subject;
	
	@Size(min=2, message="event stream should be descriptive")
	@ApiModelProperty(notes="stream associated with subject")
	private String stream;
	
	public RegisteredEvent() {
		// TODO Auto-generated constructor stub
	}

	public RegisteredEvent(@NotNull(message = "date has to be selected") Date date,
			@Size(min = 2, message = "event detail should have atleast 2 characters") String eventDetails,
			@Size(min = 2, message = "event should have atleast 2 characters") String subject,
			@Size(min = 2, message = "event stream should be descriptive") String stream) {
		super();
		this.date = date;
		this.eventDetails = eventDetails;
		this.subject = subject;
		this.stream = stream;
	}

	public RegisteredEvent(@NotNull(message = "date has to be selected") Date date, @NotNull Event event,
			@Size(min = 2, message = "event detail should have atleast 2 characters") String eventDetails) {
		super();
		this.date = date;
		this.event = event;
		this.eventDetails = eventDetails;
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

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getEventDetails() {
		return eventDetails;
	}

	public void setEventDetails(String eventDetails) {
		this.eventDetails = eventDetails;
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

	@Override
	public String toString() {
		return String.format("Registered event date and topic [date=%s, topic=%s, stream=%s, subject=%s ]", getDate(), getEventDetails(), 
				getStream(), getSubject());
	
	}

}
