package com.prm.group6.controllers;

import com.prm.group6.model.dto.BookDTO;
import com.prm.group6.model.dto.OrderDTO;
import com.prm.group6.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("/get")
    public ResponseEntity<List<OrderDTO>> getBookList(@RequestHeader(name="Authorization") String token){
        return ResponseEntity.ok(orderService.getOrderListForUser(token));
    }
}
