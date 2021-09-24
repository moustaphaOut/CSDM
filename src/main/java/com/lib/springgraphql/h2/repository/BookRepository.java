package com.lib.springgraphql.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lib.springgraphql.h2.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {}
