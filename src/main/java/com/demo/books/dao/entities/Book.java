package com.demo.books.dao.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


//ORM
@Entity
//Create Getters & Setters & constructor ...
@Data 
@AllArgsConstructor @NoArgsConstructor 
@ToString
public class Book implements Serializable{

	public enum Genre{ 
		NO_FICTION, FICTION 
	}
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	
	//Just 2 genres are possible at the moment: fiction and nonfiction
	@Enumerated(EnumType.ORDINAL)
	private Genre genre;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name = "book_author", 
		joinColumns = @JoinColumn(name = "book_id"), 
		inverseJoinColumns = @JoinColumn(name = "author_id")
	)
    private List<Author> authors;	
}
