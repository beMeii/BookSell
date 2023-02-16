package com.prm.group6.controllers;

import com.prm.group6.model.dto.OrderDTO;
import com.prm.group6.model.dto.OrderDetailDTO;
import com.prm.group6.services.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderdetails")
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;
    @GetMapping("/{id}")
    public ResponseEntity<List<OrderDetailDTO>> getBookList(@RequestHeader(name="Authorization") String token,
                                                            @PathVariable String id){
        return org.springframework.http.ResponseEntity
                .ok(orderDetailService.getOrderDetails(token,id));
    }
}
