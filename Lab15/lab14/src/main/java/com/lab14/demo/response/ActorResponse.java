package com.lab14.demo.response;

import java.io.Serializable;
import java.util.Date;

public class ActorResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private Short actor_id;
	private String first_name;
	private String last_name;
	private Date last_update;
	
	public ActorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ActorResponse(String first_name, String last_name) {
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

	public Short getActor_id() {
		return actor_id;
	}

	
}
