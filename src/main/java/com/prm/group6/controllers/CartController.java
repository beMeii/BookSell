package com.prm.group6.controllers;

import com.prm.group6.model.dto.BookDTO;
import com.prm.group6.model.dto.CartDTO;
import com.prm.group6.repositories.CartRepository;
import com.prm.group6.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;
    @GetMapping("/retrieve")
    public ResponseEntity<List<CartDTO>> getCart(@RequestHeader(name = "Authorization") String token){
        return ResponseEntity.ok(cartService.getCart(token));
    }

    @PostMapping("/add/{id}/{value}")
    public ResponseEntity<List<CartDTO>> addItem(@RequestHeader(name = "Authorization") String token, @PathVariable(name = "id") int bookId,@PathVariable(name = "value") int value){
        return ResponseEntity.ok(cartService.addItemToCart(token,bookId,value));
    }

    @DeleteMapping("/{id}/{value}")
    public ResponseEntity<List<CartDTO>> deleteItem(@RequestHeader(name = "Authorization") String token, @PathVariable(name = "id") int bookId,@PathVariable(name = "value") int value){
        return ResponseEntity.ok(cartService.deleteItemFromCart(token,bookId,value));
    }
    @DeleteMapping("/item/{id}")
    public ResponseEntity<List<CartDTO>> deleteCartItem(@RequestHeader(name = "Authorization") String token, @PathVariable(name = "id") int bookId){
        return ResponseEntity.ok(cartService.deleteCartItem(token,bookId));
    }
    @DeleteMapping("/cart")
    public ResponseEntity<List<CartDTO>> deleteCartItem(@RequestHeader(name = "Authorization") String token){
        return ResponseEntity.ok(cartService.deleteCart(token));
    }
}
