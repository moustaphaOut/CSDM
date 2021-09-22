package com.demo.books.dao.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



//ORM
@Entity
//Annotation To Create Getters & Setters & constructor ...
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Book implements Serializable {
	//
	public enum Genre{ 
		FICTION, NO_FICTION 
	}
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	
	//Just 2 genres are possible at the moment: fiction and nonfiction
	@Enumerated(EnumType.ORDINAL)
	private Genre genre;
	
	@ManyToOne
	private Author author;
}
