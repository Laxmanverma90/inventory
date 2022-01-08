package com.inventory.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dto.CustomerDto;
import com.inventory.model.Customer;
import com.inventory.repository.CustomerRepository;
import com.inventory.utils.CustomerMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements com.inventory.service.CustomerService {

	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper;
	
	@Override
	public CustomerDto getCustomer(String mobileNumber) {
		
		return customerMapper.customerToCustomerDto(customerRepository.findByMobileNumber(mobileNumber));
	}

	@Override
	public CustomerDto saveCustomer(CustomerDto customerDto) {
		
		Customer customer = customerMapper.customerDtoToCustomer(customerDto);
		customer.setUpdateDate(LocalDate.now());
		customer.setAvailability(1);
		customerRepository.save(customer);
		return getCustomer(customerDto.getMobileNumber());
	}
}