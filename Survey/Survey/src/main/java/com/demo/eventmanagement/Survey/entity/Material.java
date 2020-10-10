package com.demo.eventmanagement.Survey.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class Material {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@ApiModelProperty(notes="material for the event related to subject")
	private String material;
	
	@NotNull
	@ApiModelProperty(notes="topic discussed")
	private String topic;
	
	public Material() {
		// TODO Auto-generated constructor stub
	}

	public Material(@NotNull String material, @NotNull String topic) {
		super();
		this.material = material;
		this.topic = topic;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	@Override
	public String toString() {
		return String.format("Material topic [topic=%s ]",  getTopic());
	
	}
}
