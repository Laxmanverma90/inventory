package com.inventory.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderBill {

	private Long orderItemId;
	private Long productId;
	private String productName;
	private Long itemId;
	private String itemName;
	private BigDecimal rate;
	private Integer quantity;
	private BigDecimal amount;
}