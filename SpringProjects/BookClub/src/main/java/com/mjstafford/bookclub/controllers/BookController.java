package com.mjstafford.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.mjstafford.bookclub.models.Book;
import com.mjstafford.bookclub.services.BookService;
import com.mjstafford.bookclub.services.UserService;

@Controller
public class BookController {
	
	@Autowired 
	BookService bookService;
	
	@Autowired 
	UserService userService;

	// =============== GET ROUTES ==================
	@GetMapping("/books")
	public String books(HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		model.addAttribute("books", bookService.findAll());
		model.addAttribute("userName", session.getAttribute("UserName"));
		return "home.jsp";
	}
	
	
	@GetMapping("/books/{id}")
	public String showBook(@PathVariable("id") Long id, Model model, HttpSession session ) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		model.addAttribute("book", bookService.findById(id));
		
		return "show_book.jsp";
	}
	
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("newBook") Book newBook, HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));
		return "new_book.jsp";
	}
	
	@GetMapping("/books/{id}/edit")
	public String editBook(@PathVariable("id")Long id,@ModelAttribute("book") Book book, HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		//book contains the user so I just updated the edit form to have hidden input with user from the book
		//model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));
		model.addAttribute("book", bookService.findById(id));
		return "edit_book.jsp";
	}
	
	// =============== ACTION ROUTES ==================
	
	
	@PostMapping("/books/new")
	public String processNewBook(@Valid @ModelAttribute("newBook") Book newBook, BindingResult result, HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			//re-send the user for hidden input
			model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));
			return "new_book.jsp";
		}
		
		bookService.save(newBook);
		
		return "redirect:/books";
	}
	
	@PutMapping("/books/{id}/edit")
	public String processEditBook(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		if(result.hasErrors()) {
			//re-send the book to pre-populate all the fields
			model.addAttribute("book", bookService.findById(id));
			return "edit_book.jsp";
		}
		
		bookService.update(book);
		
		return "redirect:/books";
	}
	
}
