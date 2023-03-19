package com.prm.group6.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "BookGenre")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Table(name = "book_genre")
public class BookGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_genre_id")
    private int bookGenreId;
    @Column(name = "book_id")
    private int bookId;
    @Column(name = "genre_id")
    private int genreId;
}
