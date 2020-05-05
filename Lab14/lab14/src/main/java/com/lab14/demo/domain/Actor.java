package com.lab14.demo.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Actor {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(length = 45, nullable = false)
	private String first_name;
	@Column(length = 45, nullable = false)
	private String last_name;
	@Temporal(TemporalType.TIMESTAMP)
	private Date last_update;
	
	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Actor(String first_name, String last_name) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getLast_update() {
		return last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

	public Integer getId() {
		return id;
	}

	
}
