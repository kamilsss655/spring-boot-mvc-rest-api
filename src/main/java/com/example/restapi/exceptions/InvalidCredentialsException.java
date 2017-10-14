package com.example.restapi.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Invalid credentials.")
public class InvalidCredentialsException extends RuntimeException {

}
