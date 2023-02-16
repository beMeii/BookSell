package com.prm.group6.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "birthday")
    private Timestamp birthday;
    @Column(name = "gender")
    private String gender;
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    private String status;
}