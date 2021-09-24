package com.lib.springgraphql.h2.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.lib.springgraphql.h2.model.Author;
import com.lib.springgraphql.h2.model.Book;
import com.lib.springgraphql.h2.repository.AuthorRepository;
import com.lib.springgraphql.h2.repository.BookRepository;

@Component
public class Query implements GraphQLQueryResolver {
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;

	@Autowired
	public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	public Iterable<Author> findAllAuthors() {
		return authorRepository.findAll();
	}
	
	
	public Author getAuthorById(Long id) {
		return authorRepository.findById(id).orElse(null);
	}
	
	
	public Iterable<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	public Book bookById(Long id) {
		return bookRepository.findById(id).orElse(null);
	}

}
