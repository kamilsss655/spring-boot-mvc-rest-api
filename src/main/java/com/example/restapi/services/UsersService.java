package com.example.restapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import com.example.restapi.exceptions.UserEntityException;
import com.example.restapi.models.User;
import com.example.restapi.repositories.UsersRepository;

@Component
public class UsersService {
	private UsersRepository usersRepository;

	@Autowired
	private UsersService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	public User addUser(User user) throws UserEntityException {

		try {
			return usersRepository.save(user);

		} catch (DataIntegrityViolationException de) {
			throw new UserEntityException("Database contraint error.");
		}
	}
}
