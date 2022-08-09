package com.mjstafford.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.mjstafford.books.models.Book;
import com.mjstafford.books.services.BookService;

//this is the controller that gives back Views

@Controller
public class BooksController {

	@Autowired						//does your dependency injection for you, otherwise need a constructor to instantiate it
	BookService bookService;
	
	//get all books
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		System.out.println(books.get(0));
		return "index.jsp";
	}
	
	//get Book by id
	@GetMapping("/books/{BookId}")
	public String show(Model model, @PathVariable(value="BookId") Long BookId) {
		
		Book book = bookService.findBook(BookId);
		model.addAttribute("book", book);
		
		return "show.jsp";
	}
	
	//get the books form page
	@GetMapping("/books/new")
	public String bookForm(@ModelAttribute("book") Book book) {
		return "new.jsp";
	}
	
	//submit form to create new book
	@PostMapping("/books/new")
	public String process(@Valid @ModelAttribute("book") Book book, BindingResult result) {
//			@RequestParam("title") String title,
//			@RequestParam("description") String description,
//			@RequestParam("language") String language,
//			@RequestParam("numberOfPages") Integer numberOfPages
//			) {
		
//		bookService.createBook(new Book(title, description, language, numberOfPages));
		
		if (result.hasErrors()) {
			return "new.jsp";
		}
		
		bookService.createBook(book);
		
		return "redirect:/books";
	}
	
	//edit book form show page
    @GetMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "edit.jsp";
    }
    
    //edit book form process form submit
    //Be sure to use 'id' in your route: value="/books/{id}". Using a different path variable name will create a new instance.
    @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
        	//we can re-render this page if there are errors because it can never duplicate a submission in the db while an error exists
        	//this also automatically keeps all of the users previous input into the fields
            return "edit.jsp";
        } else {
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }
	
}
