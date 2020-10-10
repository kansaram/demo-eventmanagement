package com.demo.eventmanagement.Feedback.event;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class Feedback {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(max=5)
	private int usefulness;
	
	@Size(max=5)
	private int delivery;
	
	@Size(max=5)
	private int engage;
	
	@Size(max=5)
	private int credit;
	
	@Size(max=5)
	private int interest;
	
	@Size(max=2000, message="note should not be more then 2000 characters")
	private String Responsenote;
	
	@OneToOne
	private User user;
	
	public Feedback() {
		// TODO Auto-generated constructor stub
	}

	public Feedback(@Size(max = 5) int usefulness, @Size(max = 5) int delivery, @Size(max = 5) int engage,
			@Size(max = 5) int credit, @Size(max = 5) int interest, String responsenote) {
		super();
		this.usefulness = usefulness;
		this.delivery = delivery;
		this.engage = engage;
		this.credit = credit;
		this.interest = interest;
		Responsenote = responsenote;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getUsefulness() {
		return usefulness;
	}

	public void setUsefulness(int usefulness) {
		this.usefulness = usefulness;
	}

	public int getEngage() {
		return engage;
	}

	public void setEngage(int engage) {
		this.engage = engage;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}

	public String getResponsenote() {
		return Responsenote;
	}

	public void setResponsenote(String responsenote) {
		Responsenote = responsenote;
	}

	@Override
	public String toString() {
		return "QuestionBank [getId()=" + getId() + ", getUsefulness()=" + getUsefulness() + ", getEngage()="
				+ getEngage() + ", getCredit()=" + getCredit() + ", getInterest()=" + getInterest()
				+ ", getResponsenote()=" + getResponsenote() + "]";
	}

}
