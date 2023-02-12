package com.prm.group6.repositories;

import com.prm.group6.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,String> {
    Book findByBookId(int id);

    List<Book> findByTitleContainingOrAuthorContainingIgnoreCase(String title,String author);
}
