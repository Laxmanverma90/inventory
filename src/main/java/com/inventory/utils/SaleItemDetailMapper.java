package com.inventory.utils;

import org.mapstruct.Mapper;

import com.inventory.dto.OrderDetailDto;
import com.inventory.model.OrderDetails;

@Mapper(componentModel = "spring")
public interface SaleItemDetailMapper {

	OrderDetailDto saleItemToSaleItemDetailDto(OrderDetails saleItem);
}
