package com.demo.books.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.books.dao.BookRepository;
import com.demo.books.dao.entities.Book;


@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Book getBookById(long id) {
		return bookRepository.findById(id).orElse(null);
	}
	
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}	
	
	public Book updateBook(Long id, Book book) {
		book.setId(id);
		return bookRepository.save(book);
	}
	
	public String deleteBookById(long id) {
		bookRepository.deleteById(id);
		return "Book deleted successfully";
	}
}
