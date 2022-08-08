package com.mjstafford.books.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mjstafford.books.models.Book;
import com.mjstafford.books.services.BookService;

@RestController				//@RestController is used if you are not dealing with Views!!!
public class BooksApi {
	private final BookService bookService;

	public BooksApi(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
    @RequestMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }
    
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Book create(
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang, 
    		@RequestParam(value="pages") Integer numOfPages) {
    	
    	// creates a Book instance based off the form data
        Book book = new Book(title, desc, lang, numOfPages);
        
        // creates/saves a book in the DB and returns that book(?)
        return bookService.createBook(book);
        
    }
    
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }

    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Book update(
    		@PathVariable("id") Long id,
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang, 
    		@RequestParam(value="pages") Integer numOfPages) {
    	
    	//IN THE CONTROLLER
    	//create book 
    	//update id 
    	//then send that book via the bookService to update it
    	Book book = new Book(title, desc, lang, numOfPages);
    	book.setId(id);
    	book = bookService.updateBook(book);
    	
        return book;
        
    }
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
    
}
