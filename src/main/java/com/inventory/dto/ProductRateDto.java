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
public class ProductRateDto {
	
	private Integer id;
	private Integer productId;
	private String item;
	private BigDecimal rate;
	private LocalDate date;
	private String availability;

}