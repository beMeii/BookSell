package com.prm.group6.repositories;

import com.prm.group6.model.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    List<OrderDetail> findAllByOrderId(int orderId);
}
