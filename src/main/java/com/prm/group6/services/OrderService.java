package com.prm.group6.services;

import com.prm.group6.model.dto.OrderDTO;
import com.prm.group6.model.dto.OrderDetailDTO;
import com.prm.group6.model.dto.PaymentDTO;
import com.prm.group6.model.entity.Order;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getOrderListForUser(String token);

    OrderDTO addOrder(String token, PaymentDTO paymentDTO);

    List<OrderDetailDTO> getOrderDetails(String token, int id);
}
