package com.prm.group6.services;

import com.prm.group6.model.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getOrderListForUser(String token);

}
