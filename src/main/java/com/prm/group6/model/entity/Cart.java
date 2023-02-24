package com.prm.group6.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int cardId;
    @Column(name="quantity", nullable = false)
    @NotNull
    @Pattern(regexp = "^[0-9]+$")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    @NotNull
    private Book book;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "customer_id", nullable = false)
    private Account account;
}
