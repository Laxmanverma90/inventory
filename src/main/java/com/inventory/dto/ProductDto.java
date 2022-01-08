package com.inventory.dto;

import java.time.LocalDate;
import java.util.List;

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
public class ProductDto {

	private Long productId;
	private String productName;
	private LocalDate updateDate;
	private Integer availability;
	List<ItemDto> items;
}