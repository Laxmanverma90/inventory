package com.inventory.service;

import java.util.List;
import java.util.Optional;

import com.inventory.dto.ProductDto;
import com.inventory.model.Item;
import com.inventory.model.Product;

public interface ProductService {

	List<ProductDto> getProduct();

	List<ProductDto> getAvailableProduct();

	List<ProductDto> updateItemRate(List<ProductDto> products);

	Optional<List<Product>> getProducts();

	Optional<List<Item>> getItems();
}