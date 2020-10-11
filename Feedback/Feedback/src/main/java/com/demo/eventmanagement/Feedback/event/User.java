package com.demo.eventmanagement.Feedback.event;

import javax.mail.Address;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class User {

	
	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=2, message="username should be atleast 2 characters")
	@ApiModelProperty(notes="user to send invitation for the event")
	@Column(name="user")
	private String user;
	
	@NotNull(message="email adddress is mandatory")
	@Email
	@ApiModelProperty(notes="emailId of invited user")
	@Column(name="emailId")
	private Address emailId;
	
	@NotNull
	@ApiModelProperty(notes="event Details for sending emails")
	@Column(name="eventDetails")
	private String eventDetails;
	
	@NotNull
	@ApiModelProperty(notes="event Details for sending emails")
	@Column(name="eventId")
	private Long eventId;
	
	@OneToOne(mappedBy="user")
	private Feedback feedback;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(@Size(min = 2, message = "username should be atleast 2 characters") String user,
			@NotNull(message = "email adddress is mandatory") @Email Address emailId) {
		super();
		this.user = user;
		this.emailId = emailId;
	}

	public User( @Size(min = 2, message = "username should be atleast 2 characters") String user,
			@NotNull(message = "email adddress is mandatory") @Email Address emailId, @NotNull String eventDetails,
			@NotNull Long eventId) {
		super();
		this.user = user;
		this.emailId = emailId;
		this.eventDetails = eventDetails;
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
	
	public String getEventDetails() {
		return eventDetails;
	}

	public void setEventDetails(String eventDetails) {
		this.eventDetails = eventDetails;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	@Override
	public String toString() {
		return String.format("User invited [user=%s , emailId=%s, eventDetails=%s]", getUser(), getEmailId(), getEventDetails());
	
	}

}
