package com.prm.group6.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "FAVOURITES")
public class Favourite {
    @Id
    @Column(name ="favourite_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int favouriteId;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
