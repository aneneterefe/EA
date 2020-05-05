package com.lab13_01.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab13_01.demo.service.AddressService;
import com.lab13_01.demo.domain.Address;
@RestController
public class AddressController {

	private AddressService addressService;
	
	@Autowired
	public AddressController(AddressService addressService) {
		// TODO Auto-generated constructor stub
		this.addressService=addressService;
	}
	
	@RequestMapping("/")
	public List<Address> getAddresses(){
		return addressService.findAll();
	}
	
	
}
