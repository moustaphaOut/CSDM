package com.lib.springgraphql.h2.model;

import javax.persistence.*;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "genre")
	private String genre;

	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false, updatable = false)
	private Author author;

	
	public Book() {
	}
	
	
	public Book(String title, String genre, Author author) {
		this.title = title;
		this.genre = genre;
		this.author = author;
	}
	

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}


	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", title=" + title + ", genre=" + genre + ", author=" + author + "]";
	}
}