package com.prm.group6.repositories;

import com.prm.group6.model.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,String> {
    Book findByBookId(int id);
    Page<Book> findByTitleContainingOrAuthorContainingIgnoreCase(String title, String author, Pageable pageable);
}
