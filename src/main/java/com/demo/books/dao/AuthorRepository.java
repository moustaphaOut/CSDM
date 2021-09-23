package com.demo.books.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.books.dao.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{}
