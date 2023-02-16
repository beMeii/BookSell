package com.prm.group6.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int order_id;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone ;
    @Column(name = "status")
    private String status ;
    @Column(name = "time")
	private Timestamp time;
    @Column(name = "total_amount")
    private float total_amount ;
    @Column(name = "customer_id")
    private int customerId;
}
