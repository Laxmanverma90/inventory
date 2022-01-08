package com.inventory.dto;

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
public class CustomerDto {

	private Long customerId;
	private String customerName;
	private String mobileNumber;
	private String emailId;
	private String address;
}