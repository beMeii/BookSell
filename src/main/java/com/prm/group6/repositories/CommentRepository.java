package com.prm.group6.repositories;

import com.prm.group6.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,String> {
    List<Comment> findByBookId(int bookId);
    @Query(value = "SELECT avg(rating) FROM Comment WHERE bookId=?1")
    Double avg(int bookId);
}
