package com.inventory.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerBillDetailDto {

	private OrderBillDetailDto orderBillDetailDto;
	private CustomerDto customerDto;
	private List<OrderBillDto> orderBillDto;
}