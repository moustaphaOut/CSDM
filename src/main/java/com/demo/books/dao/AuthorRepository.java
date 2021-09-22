package com.demo.books.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.demo.books.dao.entities.Author;


@RepositoryRestResource
public interface AuthorRepository extends JpaRepository<Author, Long>{}
