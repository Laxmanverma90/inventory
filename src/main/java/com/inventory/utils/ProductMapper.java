package com.inventory.utils;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.inventory.dto.ProductDto;
import com.inventory.model.Product;

@Mapper(componentModel = "spring", uses = ItemMapper.class)
public interface ProductMapper {

	ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

	@Mapping(source = "product.items", target = "items")
	ProductDto productToProductDto(Product product);
	@Mapping(source = "productDto.items", target = "items")
	Product productDtoToProduct(ProductDto productDto);

	@Mapping(source = "products.items", target = "items")
	List<ProductDto> productsToProductsDto(List<Product> products);
	@Mapping(source = "productsDto.items", target = "items")
	List<Product> productsDtoToProducts(List<ProductDto> productsDto);
}