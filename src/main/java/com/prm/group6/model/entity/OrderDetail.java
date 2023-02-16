package com.prm.group6.model.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_details_id")
    private int orderDetailsId;
    @Column(name = "price")
    private float price;
    @Column(name = "quantity")
    private int quantity ;
    @Column(name = "book_id")
    private int bookId ;
    @Column(name = "order_id")
    private int orderId;
}
