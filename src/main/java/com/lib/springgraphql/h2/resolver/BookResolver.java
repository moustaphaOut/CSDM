package com.lib.springgraphql.h2.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.lib.springgraphql.h2.model.Author;
import com.lib.springgraphql.h2.model.Book;
import com.lib.springgraphql.h2.repository.AuthorRepository;

@Component
public class BookResolver implements GraphQLResolver<Book> {
	@Autowired
	private AuthorRepository authorRepository;

	public BookResolver(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	public Author getAuthor(Book book) {
		return authorRepository.findById(book.getAuthor().getId()).orElseThrow(null);
	}
}
