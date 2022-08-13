package com.mjstafford.bookclub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjstafford.bookclub.models.Book;
import com.mjstafford.bookclub.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;
	
	public List<Book> findAll(){
		return bookRepo.findAll();
	}

	public Book findById(Long id) {
		return bookRepo.findById(id).orElse(null);
	}

	public Book save(Book newBook) {
		return bookRepo.save(newBook);
	}

	public Book update(Book book) {
		return bookRepo.save(book);
	}
	
}
