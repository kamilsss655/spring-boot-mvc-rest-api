package com.example.restapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.restapi.models.Book;
import com.example.restapi.models.User;

public interface BookRepository extends JpaRepository<Book, Long> {
}
