package com.inventory.service;

import com.inventory.dto.CustomerDto;

public interface CustomerService {
	
	CustomerDto getCustomer(String mobileNumber);
	
	CustomerDto saveCustomer(CustomerDto customerDto);
}