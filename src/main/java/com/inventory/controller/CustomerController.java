package com.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.dto.CustomerDto;
import com.inventory.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/customer/{mobileNumber}")
	public CustomerDto getCustomer(@PathVariable("mobileNumber") String mobileNumber) {
		
		return customerService.getCustomer(mobileNumber);
	}
	
	@PostMapping("/customer")
	public CustomerDto saveCustomer(@RequestBody CustomerDto customerDto) {
		
		return customerService.saveCustomer(customerDto);
	}
}