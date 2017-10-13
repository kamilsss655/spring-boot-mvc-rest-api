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

import com.example.restapi.models.Book;
import com.example.restapi.models.User;
import com.example.restapi.repositories.BookRepository;
import com.example.restapi.repositories.UsersRepository;

@RestController
@RequestMapping("/")
public class BooksController {
	private BookRepository bookRepository;

	@Autowired
	private BooksController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

//	@GetMapping("user/{userId}")
//	public User show(@PathVariable Long userId) {
//		return usersRepository.findOne(userId);
//	}

	@PostMapping("/books")
	public Book create(@RequestBody Book book) {
		bookRepository.save(book);
		return book;
	}
}
