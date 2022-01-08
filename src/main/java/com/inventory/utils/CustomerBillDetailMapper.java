package com.inventory.utils;

import org.mapstruct.Mapper;

import com.inventory.dto.CustomerBillDetailDto;
import com.inventory.model.Order;

@Mapper(componentModel = "spring")
public interface CustomerBillDetailMapper {

	CustomerBillDetailDto billDetailToCustomerBillDetailDto(Order billDetail);

}
