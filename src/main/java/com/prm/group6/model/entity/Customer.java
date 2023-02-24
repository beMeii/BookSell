package com.prm.group6.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

@Component
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Customers")
public class Customer {
    @Id
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "birthday", nullable = false)
    @NotNull
    private Timestamp birthday;
    @Column(name = "gender", nullable = false)
    @NotNull
    @Pattern(regexp = "^(MALE|FEMALE|OTHER)$")
    private String gender;
    @Column(name = "name", nullable = false)
    @NotNull
    private String name;
    @Column(name = "status", nullable = false)
    @Pattern(regexp = "^(disabled|active)$")
    @NotNull
    private String status;
    @Column(name = "address")
    private String address;
    @Column(name="phone")
    private String phone;
}
