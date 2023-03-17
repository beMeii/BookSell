package com.prm.group6.services;

import com.prm.group6.model.OrderStatusEnum;
import com.prm.group6.model.dto.OrderDTO;
import com.prm.group6.model.dto.OrderDetailDTO;
import com.prm.group6.model.dto.PaymentDTO;
import com.prm.group6.model.entity.Order;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getOrderListForUser(String token, int pageNo, int pageSize,String sort);

    OrderDTO addOrder(String token, PaymentDTO paymentDTO);

    List<OrderDetailDTO> getOrderDetails(String token, int id, int pageNo, int pageSize);

    List<OrderDTO> getAllOrder(int pageNo, int pageSize, String sort, String sortType);

    OrderDTO changeStatus(int orderId, OrderStatusEnum status);

    List<OrderDetailDTO> adminGetOrderDetails(int id);
}
