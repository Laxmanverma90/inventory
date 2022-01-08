package com.inventory.dto.report;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.inventory.dto.CustomerDto;
import com.inventory.dto.OrderBillDetailDto;
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
public class CustomerReportDto {

	private BigDecimal totalAmount;
	private BigDecimal paidAmount;
	private BigDecimal balanceAmount;
	private CustomerDto customerDto;
	private List<OrderBillDetailDto> orderBillsDetailDto;
}
