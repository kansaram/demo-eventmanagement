package com.demo.eventmanagement.Registration.entity;

import javax.mail.Address;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class RegisteredUsers {

	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=2, message="user should have atleast 2 characters")
	@ApiModelProperty(notes="user has Registered for the event")
	private String user;
	
	@NotNull(message="email adddress is mandatory")
	@Email
	@ApiModelProperty(notes="emailId of registered user")
	private Address emailId;
	
	@NotNull(message="attendance status should be mandatory")
	@ApiModelProperty(notes="if user attends event if yes (true) not (false)")
	private boolean attendy;
	
	@NotNull(message="one event have be there for registration")
	@ApiModelProperty(notes="event registered by user")
	private String event;
	
	@NotNull(message="event id for which user is registered")
	@ApiModelProperty(notes="event id for which user is registered")
	private Long eventId;
	
	public RegisteredUsers() {
		// TODO Auto-generated constructor stub
	}

	public RegisteredUsers(@Size(min = 2, message = "user should have atleast 2 characters") String user,
			@NotNull(message = "email adddress is mandatory") @Email Address emailId,
			@NotNull(message = "attendance status should be mandatory") boolean attendy,
			@NotNull(message = "one event have be there for registration") String event,
			@NotNull(message = "event id for which user is registered") Long eventId) {
		super();
		
		this.user = user;
		this.emailId = emailId;
		this.attendy = attendy;
		this.event = event;
		this.eventId = eventId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Address getEmailId() {
		return emailId;
	}

	public void setEmailId(Address emailId) {
		this.emailId = emailId;
	}

	public boolean isAttendy() {
		return attendy;
	}

	public void setAttendy(boolean attendy) {
		this.attendy = attendy;
	}
	
	@Override
	public String toString() {
		return String.format("Registered user [user=%s, emailId=%s, attanding?=%s ]", getUser(), getEmailId(),
				isAttendy());
	
	}

}
