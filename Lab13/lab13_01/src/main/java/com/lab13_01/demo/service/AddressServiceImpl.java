package com.lab13_01.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab13_01.demo.domain.Address;
import com.lab13_01.demo.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
	
	private AddressRepository ad;
	
	@Autowired
	public AddressServiceImpl(AddressRepository ad) {
		// TODO Auto-generated constructor stub
		this.ad=ad;
	}

	@Override
	public Address save(Address address) {
		// TODO Auto-generated method stub
		return ad.save(address);
	}

	@Override
	public List<Address> findAll() {
		// TODO Auto-generated method stub
		return ad.findAll();
	}

}
