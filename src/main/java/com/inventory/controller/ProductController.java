package com.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.dto.ProductRateDto;
import com.inventory.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	List<ProductRateDto> getProducts(){
		
		return productService.getProduct();
	}
	
	@PostMapping("/products")
	List<ProductRateDto> updateProductRate(@RequestBody List<ProductRateDto> products){
		
		return productService.updateProductsRate(products);
	}
	
}
