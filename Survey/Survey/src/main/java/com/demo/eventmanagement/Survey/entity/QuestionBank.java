package com.demo.eventmanagement.Survey.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class QuestionBank {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(max=5, message="useful rating should not be more then 5 characters")
	@ApiModelProperty(notes="Is this course useful for building your future")
	private String useful = "Is this course useful for building your future";
	
	@Size(max=5)
	private int usefulness;
	
	@Size(max=5, message="author delivery rating should not be more then 5 characters")
	@ApiModelProperty(notes="Is Author delivering can be effective in grasping the content")
	private String delivered = "Is Author delivering can be effective in grasping the content";
	
	@Size(max=5)
	private int delivery;
	
	@Size(max=5, message="engaging rating should not be more then 5 characters")
	@ApiModelProperty(notes="Is conversation found engaging, synchronizing")
	private String engaging = "Is conversation found engaging, synchronizing";
	
	@Size(max=5)
	private int engage;
	
	@Size(max=5, message="event stream should be descriptive")
	@ApiModelProperty(notes="your credit to overall experience during this event can be inspiring for us on many dimentions of this subject")
	private String creditability = "your credit to overall experience during this event can be inspiring for us on many dimentions of this subject";
	
	@Size(max=5)
	private int credit;
	
	@Size(max=5, message="event stream should be descriptive")
	@ApiModelProperty(notes="Are you really interested to join our conversation from now on")
	private String interested = "Are you really interested to join our conversation from now on";
	
	@Size(max=5)
	private int interest;
	
	@Size(max=2000, message="note should not be more then 2000 characters")
	@ApiModelProperty(notes="What we have missed, we are really interested to know for success")
	private String note = "What we have missed, we are really interested to know for success";
	
	private String Responsenote;
	
	public QuestionBank() {
		// TODO Auto-generated constructor stub
	}

	public QuestionBank(@Size(max = 5) int usefulness, @Size(max = 5) int delivery, @Size(max = 5) int engage,
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

	public String getDelivered() {
		return delivered;
	}

	public void setDelivered(String delivered) {
		this.delivered = delivered;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
