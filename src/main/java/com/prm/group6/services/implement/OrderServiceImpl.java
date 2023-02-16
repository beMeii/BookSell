package com.prm.group6.services.implement;

import com.prm.group6.model.dto.OrderDTO;
import com.prm.group6.model.entity.Order;
import com.prm.group6.repositories.AccountRepository;
import com.prm.group6.repositories.OrderRepository;
import com.prm.group6.services.JwtService;
import com.prm.group6.services.OrderService;
import com.prm.group6.services.mappers.OrderMapper;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    JwtService jwtService;
    @Autowired
    AccountRepository accountRepository;
    @Override
    public List<OrderDTO> getOrderListForUser(String token) {
//        System.out.println("Token receive in OrderService:"+token);
        token = token.substring(7);
        String userName=jwtService.extractEmail(token);
//        System.out.println("Subject from token: "+ userName);
        List<OrderDTO> orderDTOList = new ArrayList<>();
        List<Order> orderList = orderRepository.findAllByCustomerId(accountRepository.findByEmail(userName).get().getAccountId());
        orderList.forEach(order -> {
            OrderDTO orderDTO = OrderMapper.INSTANCE.orderToOrderDto(order);
            orderDTOList.add(orderDTO);
            }
        );
        return orderDTOList;
    }
}
