package com.inventory.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

	private Long itemId;
	private Long productId;
	private String item;
	private BigDecimal rate;
	private LocalDate updateDate;
	private Integer availability;
}