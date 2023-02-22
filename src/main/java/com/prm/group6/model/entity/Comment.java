package com.prm.group6.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int commentId;
    @Column(name = "content")
    private String content;
    @Column(name = "rating")
    private double rating;
    @Column(name = "timestamp")
    private LocalDateTime timestamp;
    @Column(name = "book_id",nullable = false)
    private int bookId;
    @Column(name = "customer_id",nullable = false)
    private int customerId;
}
