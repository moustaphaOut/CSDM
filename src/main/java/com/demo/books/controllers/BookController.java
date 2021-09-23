package com.demo.books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.books.dao.entities.Book;
import com.demo.books.services.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	
	//ADD Book
	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book book) {
		return bookService.createBook(book);
	}
	
	//GET Book By ID
	@GetMapping("/book/{id}")
	public Book getBookById(@PathVariable long id) {
		return bookService.getBookById(id);
	}
	
	//GET All Books
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookService.getBooks();
	}
	
	//UPDATE Book
	@PutMapping("/book/{id}")
	public Book updateBook(@PathVariable long id, @RequestBody Book book) {
		return bookService.updateBook(id, book);
	}
	
	//DELETE Book
	@DeleteMapping("/book/{id}")
	public String deleteBook(@PathVariable long id) {
		return bookService.deleteBookById(id);
	}
}
