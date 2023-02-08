package com.prm.group6.repositories;

import com.prm.group6.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account,String> {
    Boolean existsByEmail(String email);
}
