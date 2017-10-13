package com.example.restapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class UserEntityException extends RuntimeException {

	public UserEntityException(String message) {
		super(message);
	}

}
