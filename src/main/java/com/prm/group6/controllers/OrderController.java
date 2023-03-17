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
    public ResponseEntity<List<OrderDTO>> getOrders(@RequestHeader(name="Authorization") String token,
                                                    @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
                                                    @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
                                                    @RequestParam(value = "sort", defaultValue = "time", required = false) String sort){
        return ResponseEntity.ok(orderService.getOrderListForUser(token,pageNo,pageSize,sort));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<List<OrderDetailDTO>> getOrderDetails(@RequestHeader(name="Authorization") String token,
                                                                @PathVariable int id,
                                                                @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
                                                                @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize){
        return ResponseEntity.ok(orderService.getOrderDetails(token,id,pageNo,pageSize));
    }
    @PostMapping("/payment")
    public ResponseEntity<OrderDTO> addOrder(@RequestHeader (name="Authorization") String token, @RequestBody PaymentDTO paymentDTO){
        return ResponseEntity.ok(orderService.addOrder(token,paymentDTO));
    }

}
