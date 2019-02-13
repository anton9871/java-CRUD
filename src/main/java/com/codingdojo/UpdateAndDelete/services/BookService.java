package com.codingdojo.UpdateAndDelete.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.UpdateAndDelete.models.Book;
import com.codingdojo.UpdateAndDelete.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    public boolean deleteBook(Long id) {
    	bookRepository.deleteById(id);
    	return true;
    }
    
    public Book updateBook(Long id, Book updateBook) {
    	Book book = this.findBook(id);
    	book.setTitle(updateBook.getTitle());
    	book.setDescription(updateBook.getDescription());
    	book.setLanguage(updateBook.getLanguage());
    	book.setNumberOfPages(updateBook.getNumberOfPages());
    	return bookRepository.save(book);
    }

}
