package com.inventory.model;

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
public class ProductRateDao {
	
	private Integer id;
	private Integer productId;
	private String item;
	private BigDecimal rate;
	private LocalDate date;
	private String availability;
}