package com.prm.group6.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Genre")
@Table(name = "genres")
@Data
@Getter
@Setter
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private int genreId;
    @Column(name = "genre_name")
    private String genreName;
}
