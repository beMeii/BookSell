package com.prm.group6.repositories;

import com.prm.group6.model.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    List<OrderDetail> findAllByOrder_OrderIdAndOrder_CustomerId(int id, int cusId, Pageable pageable);


    List<OrderDetail> findAllByOrder_OrderId(int id);
}
