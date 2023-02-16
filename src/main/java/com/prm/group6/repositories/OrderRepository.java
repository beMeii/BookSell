package com.prm.group6.repositories;

import com.prm.group6.model.dto.OrderDTO;
import com.prm.group6.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByCustomerId(int customerId);
}
