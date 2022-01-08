package com.inventory.service;

import java.util.List;

import com.inventory.dto.OrderDto;
import com.inventory.dto.CustomerBillDetailDto;
import com.inventory.dto.CustomerDto;
import com.inventory.dto.ProductDto;

public interface DailySaleService {

	List<ProductDto> getProduct();
	
	CustomerDto getCustomer(String mobileNumber);
	
	CustomerBillDetailDto saveBillDetail(OrderDto orderDto);
}
