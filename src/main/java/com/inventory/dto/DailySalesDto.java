package com.inventory.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DailySalesDto {

	private Integer id;
	private String item;
	private int quantity;
	private BigDecimal rate;
	private BigDecimal amount;
	private Integer customerId;
	private Integer bill_id;
	private Integer login_id;
}
