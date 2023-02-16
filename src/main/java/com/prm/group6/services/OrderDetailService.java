package com.prm.group6.services;

import com.prm.group6.model.dto.OrderDetailDTO;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetailDTO> getOrderDetails(String token, String id);
}
