package com.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.dto.OrderDto;
import com.inventory.dto.CustomerBillDetailDto;
import com.inventory.dto.CustomerDto;
import com.inventory.dto.ProductDto;
import com.inventory.service.DailySaleService;

@RestController
public class DailySaleController {

	@Autowired
	private DailySaleService dailySaleService;
	
	
	@GetMapping("/dailysale")
	public List<ProductDto> getItems() {
		
		return dailySaleService.getProduct();
	}
	
	@PostMapping("/dailysale")
	public CustomerBillDetailDto saveBillDetail(@RequestBody OrderDto orderDto) {
		
		return dailySaleService.saveBillDetail(orderDto);
	}
}
