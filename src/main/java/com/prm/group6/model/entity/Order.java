package com.prm.group6.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "book_id")
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
    private int customer_id;
}
