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

import com.example.restapi.models.User;
import com.example.restapi.repositories.UsersRepository;
import com.example.restapi.services.UsersService;

@RestController
@RequestMapping("/")
public class UsersController {
	private UsersRepository usersRepository;
	private UsersService usersService;

	@Autowired
	private UsersController(UsersRepository usersRepository, UsersService usersService) {
		this.usersRepository = usersRepository;
		this.usersService = usersService;
	}

	@GetMapping("users")
	public List<User> index() {
		return usersRepository.findAll();
	}

	@GetMapping("user/{userId}")
	public User show(@PathVariable Long userId) {
		return usersRepository.findOne(userId);
	}

	@GetMapping("users/search/{email:.+}")
	public List<User> show(@PathVariable String email) {
		return usersRepository.findByEmailContainingIgnoreCase(email);
	}

	@PostMapping("users")
	public User create(@RequestBody User user) {
		return usersService.addUser(user);
	}

	@PutMapping("/user/{userId}")
	public User update(@PathVariable Long userId, @RequestBody User user) {
		User currentUser = usersRepository.findOne(userId);
		currentUser.setEmail(user.getEmail());
		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		return usersRepository.save(currentUser);
	}

	@DeleteMapping("user/{userId}")
	public void delete(@PathVariable Long userId) {
		usersRepository.delete(userId);
		;
	}
}
