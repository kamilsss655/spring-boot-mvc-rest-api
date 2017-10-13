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
import com.example.restapi.models.User;
import com.example.restapi.params.SignInParam;
import com.example.restapi.repositories.UsersRepository;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	private UsersRepository usersRepository;

	@Autowired
	private AuthenticationController(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@PostMapping("/sign_in")
	public User update(@RequestBody SignInParam param) {
		User user = usersRepository.findByEmailAndPassword(param.getEmail(), param.getPassword());
	    if (user == null) throw new InvalidCredentialsException();
	    return user;
	}
}
