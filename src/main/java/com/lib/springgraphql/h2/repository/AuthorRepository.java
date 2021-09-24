package com.lib.springgraphql.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lib.springgraphql.h2.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {}