package com.inventory.dto.report;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.inventory.dto.OrderBillDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemReportDto {

	private LocalDate fromDate;
	private LocalDate toDate;
	private String userName;
	private BigDecimal totalAmount;
	private BigDecimal paidAmount;
	private BigDecimal balanceAmount;
	private List<OrderBillDto> orderBillDto;
}