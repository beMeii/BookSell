package com.prm.group6.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Genre")
@Table(name = "genres")
@Data
@Getter
@Setter
public class Genre {
    @Id
    @Column(name = "genre_id")
    private int genreId;
    @Column(name = "genre_name")
    private String genreName;
}
