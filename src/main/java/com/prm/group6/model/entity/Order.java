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
@Builder
@AllArgsConstructor
@NoArgsConstructor  
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "address", nullable = false)
    @NotNull
    private String address;
    @Column(name = "phone", nullable = false)
    @Pattern(regexp = "^[0-9]+$")
    @NotNull
    private String phone ;
    @Column(name = "status",nullable = false)
    @NotNull
    private String status ;
    @Column(name = "time",nullable = false)
    @NotNull
	private Timestamp time;
    @Column(name = "total_amount",nullable = false)
    @NotNull
    @Pattern(regexp = "^\\d+(\\.\\d+)?$")
    private float total_amount;
    @Column(name = "customer_id",nullable = false)
    @NotNull
    private int customerId;
}
