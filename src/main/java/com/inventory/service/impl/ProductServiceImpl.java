package com.inventory.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dto.ItemDto;
import com.inventory.dto.ProductDto;
import com.inventory.exception.ItemUpdateException;
import com.inventory.exception.ProductNotFoundException;
import com.inventory.model.Item;
import com.inventory.model.Product;
import com.inventory.repository.ItemRepository;
import com.inventory.repository.ProductRepository;
import com.inventory.service.ProductService;
import com.inventory.utils.ClazzMapper;
import com.inventory.utils.ItemMapper;
import com.inventory.utils.ProductMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductMapper productMapper;
	private final ItemRepository itemRepository;
	private final ProductRepository productRepository;
	private final ItemMapper itemMapper;

	@Override
	public List<ProductDto> getProduct() {

		return productMapper.productsToProductsDto(productRepository.findAll());
	}

	@Override
	public List<ProductDto> getAvailableProduct() {

		Optional<List<Product>> products = getProducts();

		if (!products.isPresent()) {
			throw new ProductNotFoundException();
		}

		List<ProductDto> productsDto = new ArrayList<>();
		for (Product product : products.get()) {
			ProductDto productDto = productMapper.productToProductDto(product);
			Optional<List<Item>> items = getItemByProductId(product.getProductId());
			if (items.isPresent()) {
				productDto.setItems(itemMapper.itemsToItemsDto(items.get()));
			}
			productsDto.add(productDto);
		}
		return productsDto;
	}

	private Optional<List<Item>> getItemByProductId(Long productId) {
		return Optional.ofNullable(itemRepository.findByProductIdAndAvailability(productId, 1));
	}

	public Optional<List<Item>> getItems() {
		return Optional.ofNullable(itemRepository.findByAvailability(1));
	}

	public Optional<List<Product>> getProducts() {
		return Optional.ofNullable(productRepository.findByAvailability(1));
	}

	@Override
	public List<ProductDto> updateItemRate(List<ProductDto> productsDto) {

		List<Product> products = productMapper.productsDtoToProducts(productsDto);

		if (productRepository.saveAll(products) == null) {
			throw new ItemUpdateException();
		}
		return getProduct();
	}
}
