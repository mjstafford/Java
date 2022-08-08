package com.mjstafford.books.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mjstafford.books.models.Book;
import com.mjstafford.books.services.BookService;

//this is the controller that gives back Views

@Controller
public class BooksController {

	@Autowired						//does your dependency injection for you, otherwise need a constructor to instantiate it
	BookService bookService;
	
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		System.out.println(books.get(0));
		return "index.jsp";
	}
	
	@GetMapping("/books/{BookId}")
	public String show(Model model, @PathVariable(value="BookId") Long BookId) {
		
		Book book = bookService.findBook(BookId);
		model.addAttribute("book", book);
		
		return "show.jsp";
	}
	
}
