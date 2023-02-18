package com.prm.group6.services;

import com.prm.group6.model.dto.AccountDTO;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    public AccountDTO signUp(AccountDTO accountDTO);
    public AccountDTO signIn(AccountDTO AccountDTO);
}
