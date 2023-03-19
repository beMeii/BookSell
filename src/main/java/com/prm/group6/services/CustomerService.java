package com.prm.group6.services;

import com.prm.group6.model.dto.CustomerDTO;
import com.prm.group6.model.dto.CustomerUpdateStatusRequest;
import com.prm.group6.model.dto.ListResponse;
import com.prm.group6.model.entity.Customer;
import org.springframework.stereotype.Service;

public interface CustomerService {
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
    CustomerDTO updateFirebaseToken(String token, String firebaseToken);
    ListResponse getCustomerList(int pageNo, int pageSize, String sort, String sortType);
    Customer updateCustomerStatus(CustomerUpdateStatusRequest request);
}
