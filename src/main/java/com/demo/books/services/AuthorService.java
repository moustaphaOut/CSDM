package com.demo.books.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.books.dao.AuthorRepository;
import com.demo.books.dao.entities.Author;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
	
	public Author createAuthor(Author author) {
		return authorRepository.save(author);
	}
	
	public Author getAuthorById(long id) {
		return authorRepository.findById(id).orElse(null);
	}
	
	public List<Author> getAuthors() {
		return authorRepository.findAll();
	}	
}
