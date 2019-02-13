package com.codingdojo.UpdateAndDelete.controllers;



import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.UpdateAndDelete.models.Book;
import com.codingdojo.UpdateAndDelete.services.BookService;

@RestController
public class BooksApi {
    private final BookService bookService;
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }
    @RequestMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }
    
    @PostMapping("/api/books")
    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
    
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }
    
    @DeleteMapping("/api/book/{id}")
    public boolean delete(@PathVariable("id") Long id) {
    	return bookService.deleteBook(id);
    }
    
    @PutMapping("/api/book/{id}")
    public Book update(@PathVariable("id") Long id, Book inputBook) {
    	Book book = bookService.updateBook(id, inputBook);
    	return book;
    	
    }
    
}
