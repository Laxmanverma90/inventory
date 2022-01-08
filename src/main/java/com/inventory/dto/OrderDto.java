package com.inventory.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

	private BigDecimal totalAmount;
	private BigDecimal balanceAmount;
	private LocalDateTime orderDate;
	private LocalDateTime billDate;
	private String remarks;
	private Set<OrderDetailDto> orderDetailsDto;
	private CustomerDto customerDto;
}