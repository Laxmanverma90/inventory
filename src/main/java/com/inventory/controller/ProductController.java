package com.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.dto.ProductDto;
import com.inventory.model.Item;
import com.inventory.model.Product;
import com.inventory.repository.ItemRepository;
import com.inventory.repository.ProductRepository;
import com.inventory.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	List<ProductDto> getProducts() {

		return productService.getProduct();
	}
	
	@PutMapping("/products")
	List<ProductDto> updateProductRate(@RequestBody List<ProductDto> products) {

		return productService.updateItemRate(products);
	}

}
