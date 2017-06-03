package com.darthmaximus.wrkshp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException() {
		super();
	}
	
	public CustomerNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CustomerNotFoundException(Throwable cause) {
		super(cause);
	}
}
