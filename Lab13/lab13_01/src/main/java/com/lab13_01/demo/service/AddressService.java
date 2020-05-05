package com.lab13_01.demo.service;

import java.util.List;

import com.lab13_01.demo.domain.Address;

public interface AddressService {

	public Address save(Address address);
	public List<Address> findAll();
}
