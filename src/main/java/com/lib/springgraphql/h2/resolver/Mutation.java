package com.lib.springgraphql.h2.resolver;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.lib.springgraphql.h2.model.Author;
import com.lib.springgraphql.h2.model.Book;
import com.lib.springgraphql.h2.repository.AuthorRepository;
import com.lib.springgraphql.h2.repository.BookRepository;

import javassist.NotFoundException;


@Component
public class Mutation implements GraphQLMutationResolver {
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;

	@Autowired
	public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	public Author createAuthor(String firstName,String lastName,String birthDate) {
		Author author = new Author();
		author.setFirstName(firstName);
		author.setLastName(lastName);
		author.setBirthDate(birthDate);

		authorRepository.save(author);

		return author;
	}

	public Book createBook(String title, String genre, Long authorId) {
		Book book = new Book();
		book.setAuthor(new Author(authorId));
		book.setTitle(title);
		book.setGenre(genre);

		bookRepository.save(book);

		return book;
	}
	
	
	public boolean deleteBook(Long id) {
		bookRepository.deleteById(id);
		return true;
	}

	public Book updateBook(Long id, String title, String genre) throws NotFoundException {
		Optional<Book> optBook = bookRepository.findById(id);

		if (optBook.isPresent()) {
			Book book = optBook.get();

			if (title != null)
				book.setTitle(title);
			if (genre != null)
				book.setGenre(genre);

			bookRepository.save(book);
			return book;
		}

		throw new NotFoundException("Not found Book to update!");
	}
}
