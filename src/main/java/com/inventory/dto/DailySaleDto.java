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
public class DailySaleDto {
	
	private Integer billId;
	private Integer customerId;
	private Integer loginId;
	private BigDecimal billAmount;
	
	class BillDetails{
		
		private Integer id;
		private String item;
		private int quantity;
		private BigDecimal rate;
		private BigDecimal amount;
	}
}