package com.prm.group6.repositories;

import com.prm.group6.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findById(int id);
}
