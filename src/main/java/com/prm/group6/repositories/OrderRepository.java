package com.prm.group6.repositories;

import com.prm.group6.model.dto.OrderDTO;
import com.prm.group6.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByCustomerId(int customerId, Pageable pageable);

    Order findByOrderId(int orderId);
}
