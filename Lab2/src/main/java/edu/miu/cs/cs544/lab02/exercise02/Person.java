package edu.miu.cs.cs544.lab02.exercise02;

import java.util.Date;

public class Person {

	private Long id;
	private String firstname;
	private String lastname;
	private Date dateOfBirth;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String firstname, String lastname, Date dateOfBirth) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateOfBirth = dateOfBirth;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", dateOfBirth="
				+ dateOfBirth + "]";
	}
	
}
