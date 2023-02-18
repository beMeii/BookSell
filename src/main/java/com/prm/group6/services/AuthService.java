package com.prm.group6.services;

import com.prm.group6.model.dto.AccountDTO;
import com.prm.group6.model.dto.CustomerDTO;

public interface AuthService {
    AccountDTO addCustomerAccount(AccountDTO accountDTO);

    CustomerDTO getCustomerDetails(AccountDTO signInDTO);
}
