package com.mjstafford.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mjstafford.books.models.Book;
import com.mjstafford.books.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepo;
	
	//create a repository instance that we will use in all the methods
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
    // returns all the books (returns raw data ?)
    public List<Book> allBooks() {
        return bookRepo.findAll();
    }
    
    // creates a book (returns raw data ?)
    public Book createBook(Book b) {
        return bookRepo.save(b);		//save() comes automatically due to extended CrudRepository
    }
    
    // retrieves a book (returns raw data ?)
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    //update a book
    public Book updateBook(Book book) {
    	return bookRepo.save(book);
    }

	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
}
