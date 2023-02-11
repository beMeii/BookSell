package com.prm.group6.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "BookGenre")
@Data
@Getter
@Setter
@Table(name = "book_genre")
public class BookGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_genre_id")
    private String bookGenreId;
    @Column(name = "book_id")
    private int bookId;
    @Column(name = "genre_id")
    private int genreId;
}
