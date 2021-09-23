package com.demo.books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.books.dao.entities.Author;
import com.demo.books.services.AuthorService;

@RestController
public class AuthorController {
	@Autowired
	private AuthorService authorService;
	
	//ADD Author
	@PostMapping("/addAuthor")
	public Author addAuthor(@RequestBody Author author) {
		return authorService.createAuthor(author);
	}
	
	//GET Author By ID
	@GetMapping("/author/{id}")
	public Author getAuthorById(@PathVariable long id) {
		return authorService.getAuthorById(id);
	}
	
	//GET All Authors
	@GetMapping("/authors")
	public List<Author> getAllAuthors() {
		return authorService.getAuthors();
	}
}
