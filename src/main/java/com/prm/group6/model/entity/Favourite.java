package com.prm.group6.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

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
    @JoinColumn(name = "customer_id", nullable = false)
    @NotNull
    private Account account;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
}
