package com.prm.group6.repositories;

import com.prm.group6.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findById(int id);
    @Query("SELECT name FROM Customer Where customerId=?1 ")
    String findNameByCustomerId(int customerId);
}
