package com.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class APIExceeption extends RuntimeException {
	private String message;

	public APIExceeption(String message) {
		super(message);
		this.message = message;
	}

}
