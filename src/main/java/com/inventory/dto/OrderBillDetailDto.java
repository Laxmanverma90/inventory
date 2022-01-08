package com.inventory.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderBillDetailDto {

	private Long orderId;
	private BigDecimal totalAmount;
	private BigDecimal paidAmount;
	private BigDecimal balanceAmount;
	private LocalDate orderDate;
	private LocalDate billDate;
	private String biller;
	private String remarks;
}