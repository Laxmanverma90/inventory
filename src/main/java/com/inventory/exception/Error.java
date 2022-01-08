package com.inventory.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error {

	private String errorCode;
	private String errorMessage;
	private LocalDateTime dateTime;
	private String source;
}
