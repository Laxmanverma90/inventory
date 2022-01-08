package com.inventory.mapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestClkass {

	public static void main(String[] args) {
		
		BigDecimal total = new BigDecimal(0);
		total = total.add(new BigDecimal(100));
		total = total.add(new BigDecimal(200));
		System.out.print(total);
	}
}
