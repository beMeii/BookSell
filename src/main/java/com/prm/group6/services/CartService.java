package com.prm.group6.services;

import com.prm.group6.model.dto.CartDTO;

import java.util.List;

public interface CartService {
    public List<CartDTO> getCart(String token);

    public List<CartDTO> addItemToCart(String token, int bookId, int value);

    public List<CartDTO> deleteItemFromCart(String token, int bookId, int value);

    public List<CartDTO> deleteCart(String token);

    public List<CartDTO> deleteCartItem(String token, int bookId);
}
