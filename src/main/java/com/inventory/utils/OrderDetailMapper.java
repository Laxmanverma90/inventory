package com.inventory.utils;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.inventory.model.OrderDetails;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {

	OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);

	/*
	 * SaleItem saleItemDtoToSaleItem(SaleItemDto saleItemDto);
	 * 
	 * Set<SaleItem> saleItemDtoToSaleItem(Set<SaleItemDto> saleItemDto);
	 * 
	 * SaleItemDto saleItemToSaleItemDto(SaleItem saleItem);
	 * 
	 * Set<SaleItemDto> saleItemToSaleItemDto(Set<SaleItem> saleItem);
	 */
}
