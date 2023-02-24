package com.prm.group6.controllers;

import com.prm.group6.model.dto.OrderDTO;
import com.prm.group6.model.dto.OrderDetailDTO;
import com.prm.group6.model.dto.PaymentDTO;
import com.prm.group6.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/get/{id}")
    public ResponseEntity<List<OrderDetailDTO>> getBookList(@RequestHeader(name="Authorization") String token,
                                                            @PathVariable int id){
        return ResponseEntity.ok(orderService.getOrderDetails(token,id));
    }
    @PostMapping("/payment")
    public ResponseEntity<OrderDTO> addOrder(@RequestHeader (name="Authorization") String token, @RequestBody PaymentDTO paymentDTO){
        return ResponseEntity.ok(orderService.addOrder(token,paymentDTO));
    }

}
