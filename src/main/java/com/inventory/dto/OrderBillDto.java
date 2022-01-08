package com.inventory.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderBillDto {

	private Long orderItemId;
	private Long productId;
	private String productName;
	private Long itemId;
	private String itemName;
	private BigDecimal rate;
	private Integer quantity;
	private BigDecimal amount;
}