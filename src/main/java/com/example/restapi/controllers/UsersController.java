package com.example.restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.models.User;
import com.example.restapi.repositories.UsersRepository;

@RestController
@RequestMapping("/")
public class UsersController {
	private UsersRepository usersRepository;

	@Autowired
	private UsersController(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@GetMapping("user/{userId}")
	public User show(@PathVariable Long userId) {
		return usersRepository.findOne(userId);
	}
	
	@PostMapping("users")
	public User create(@RequestBody User user) {
		return usersRepository.save(user);
	}
	
	 @PutMapping("/user/{userId}")
	 public User update (@PathVariable Long userId, @RequestBody User user){
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
