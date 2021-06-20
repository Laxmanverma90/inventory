package com.inventory.service;

import java.util.List;

import com.inventory.dto.ProductRateDto;

public interface ProductService {
	
	List<ProductRateDto> getProduct();

	List<ProductRateDto> updateProductsRate(List<ProductRateDto> products);

}
