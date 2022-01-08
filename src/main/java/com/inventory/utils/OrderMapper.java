package com.inventory.utils;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.inventory.dto.OrderDto;
import com.inventory.model.Order;

@Mapper(componentModel = "spring", uses = OrderDetailMapper.class)
//@Mapper(componentModel = "cdi", uses = EngineMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OrderMapper {

	OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

	@Mapping(source = "OrderDto.orderDetailsDto", target = "orderDetails")
	Order OrderDtoToOrder(OrderDto OrderDto);

	@Mapping(source = "Order.orderDetails", target = "orderDetailsDto")
	OrderDto OrderToOrderDto(Order Order);
}
