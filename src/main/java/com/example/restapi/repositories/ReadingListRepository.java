package com.example.restapi.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.models.Book;

public interface ReadingListRepository extends JpaRepository<Book, Long> {
	List<Book> findByReader(String reader);
}