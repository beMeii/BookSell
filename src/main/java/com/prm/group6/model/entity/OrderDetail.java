package com.prm.group6.model.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_details_id")
    private int orderDetailsId;
    @Column(name = "price",nullable = false)
    @NotNull
    @Pattern(regexp = "^\\d+(\\.\\d+)?$")
    private float price;
    @Column(name = "quantity", nullable = false)
    @NotNull
    @Pattern(regexp = "^[0-9]+$")
    private int quantity ;
    @ManyToOne
    @JoinColumn(name = "book_id",nullable = false)
    @NotNull
    private Book book;
    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    @NotNull
    private Order order;
}
