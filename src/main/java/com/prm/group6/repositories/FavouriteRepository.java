package com.prm.group6.repositories;

import com.prm.group6.model.entity.Favourite;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavouriteRepository extends JpaRepository<Favourite, Integer> {
    List<Favourite> findAllByAccountAccountId(int id, Pageable pageable);
    Favourite findByAccount_AccountIdAndBook_BookId(int accountId, int bookId);
}
