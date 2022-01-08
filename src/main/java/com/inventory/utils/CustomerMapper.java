package com.inventory.utils;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.inventory.dto.CustomerDto;
import com.inventory.model.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

	Customer customerDtoToCustomer(CustomerDto customerDto);
	
	CustomerDto customerToCustomerDto(Customer customer);
}
