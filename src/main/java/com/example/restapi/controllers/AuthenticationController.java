package com.example.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.exceptions.InvalidCredentialsException;
import com.example.restapi.generators.TokenGenerator;
import com.example.restapi.models.Token;
import com.example.restapi.models.User;
import com.example.restapi.params.SignInParam;
import com.example.restapi.repositories.TokenRepository;
import com.example.restapi.repositories.UsersRepository;
import com.example.restapi.services.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	private AuthenticationService authenticationService;

	@Autowired
	public AuthenticationController(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	@PostMapping("/sign_in")
	public Token update(@RequestBody SignInParam param) {
	    return authenticationService.signIn(param);
	}
}
