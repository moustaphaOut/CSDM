package com.demo.books.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.demo.books.dao.entities.Book;
//Cross Origin
import org.springframework.web.bind.annotation.CrossOrigin;

//(origins = "http://localhost:3000")
@CrossOrigin("*")
@RepositoryRestResource
//allowedHeaders = "*"
public interface BookRepository extends JpaRepository<Book, Long>{}
