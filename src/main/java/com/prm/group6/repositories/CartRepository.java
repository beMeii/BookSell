package com.prm.group6.repositories;

import com.prm.group6.model.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    List<Cart> findAllByAccount_AccountId(int accountId);
    Cart findByAccount_AccountIdAndBook_BookId(int accountId, int bookId);
    List<Cart> findAllByAccount_AccountIdAndBook_BookId(int accountId, int bookId);
}
