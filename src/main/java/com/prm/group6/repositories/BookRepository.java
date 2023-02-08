package com.prm.group6.repositories;

import com.prm.group6.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,String> {
    Book findByBookId(int id);

}
