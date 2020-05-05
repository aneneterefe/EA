package com.lab13_01.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lab13_01.demo.domain.Address;

@Repository
public class AddressRepository {
	
	private HashMap<Long, Address> addresses;

	public AddressRepository() {
		addresses=new HashMap<Long, Address>();
		//populate data
		populate();
	}
	public Address save(Address address) {
		return addresses.put(address.getId(), address);
	}
	
	public List<Address> findAll(){
		List<Address> valueList = new ArrayList<Address>(addresses.values());
		return valueList;
	}
	
	public void populate() {
		Address a1=new Address(1L, "address st 1","address city 1", "11111");
		Address a2=new Address(2L, "address st 2","address city 2", "22222");
		Address a3=new Address(3L, "address st 3","address city 3", "33333");
		Address a4=new Address(4L, "address st 4","address city 4", "44444");
		save(a1);
		save(a2);
		save(a3);
		save(a4);
	}
}
