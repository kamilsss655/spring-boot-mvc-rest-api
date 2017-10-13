package com.example.restapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.restapi.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
	List<User> findByEmailContainingIgnoreCase(String email);
	User findByEmailAndPassword(String email, String password);
}
