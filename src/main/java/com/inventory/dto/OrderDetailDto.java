package com.inventory.dto;

import java.math.BigDecimal;

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
public class OrderDetailDto {

	private Long id;
	private Long itemId;
	private Integer quantity;
	private BigDecimal rate;	
	private BigDecimal amount;
	private Long orderId;
}