package com.demo.books.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.books.dao.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{}
