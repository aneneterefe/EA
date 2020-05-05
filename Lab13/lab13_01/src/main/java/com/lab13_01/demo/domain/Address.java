package com.lab13_01.demo.domain;

public class Address {

	private Long id;
	private String street;
	private String city;
	private String zip;

	public Address(Long id, String street, String city, String zip) {
		super();
		this.id=id;
		this.street = street;
		this.city = city;
		this.zip = zip;
	}

	public Long getId() {
		return id;
	}
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
