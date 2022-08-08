package com.mjstafford.books.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mjstafford.books.models.Book;

//CREATE, READ, UPDATE, DELETE
//interface is a contract between what the class should have

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{	//where Long is the ID data type
    
	// this method retrieves all the books from the database
    List<Book> findAll();
    
    // this method finds books with descriptions containing the search string
    List<Book> findByDescriptionContaining(String search);
    
    // this method counts how many titles contain a certain string
    Long countByTitleContaining(String search);
    
    // this method deletes a book that starts with a specific title
    Long deleteByTitleStartingWith(String search);
	
}
