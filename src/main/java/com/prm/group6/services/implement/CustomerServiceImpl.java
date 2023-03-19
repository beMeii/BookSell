package com.prm.group6.services.implement;

import com.prm.group6.exceptions.BookException;
import com.prm.group6.model.ErrorEnum;
import com.prm.group6.model.SortTypeEnum;
import com.prm.group6.model.dto.BookDTO;
import com.prm.group6.model.dto.CustomerDTO;
import com.prm.group6.model.dto.CustomerUpdateStatusRequest;
import com.prm.group6.model.dto.ListResponse;
import com.prm.group6.model.entity.Account;
import com.prm.group6.model.entity.Book;
import com.prm.group6.model.entity.Customer;
import com.prm.group6.repositories.CustomerRepository;
import com.prm.group6.services.CustomerService;
import com.prm.group6.services.JwtService;
import com.prm.group6.services.mappers.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    JwtService jwtService;

    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(customerDTO.getCustomerId());
        customerRepository.save(customer);
        customerDTO = CustomerMapper.INSTANCE.customerToCustomerDto(customer);
        return customerDTO;
    }

    public CustomerDTO updateFirebaseToken(String token, String firebaseToken) {
        Account acc = jwtService.getAccount(token);
        Customer customer = customerRepository.findById(acc.getAccountId());

        customer.setDeviceToken(firebaseToken);
        customerRepository.save(customer);

        CustomerDTO customerDTO = CustomerMapper.INSTANCE.customerToCustomerDto(customer);
        return customerDTO;
    }


    public ListResponse getCustomerList(int pageNo, int pageSize, String sort, String sortType) {
        ListResponse listResponse = new ListResponse();
        List<CustomerDTO> customerDTOList= new ArrayList<>();
        Pageable pageable;
        if (SortTypeEnum.DESC.name().equals(sortType)){
            pageable = PageRequest.of(pageNo, pageSize, Sort.by(sort).descending());
        }
        if (SortTypeEnum.ASC.name().equals(sortType)){
            pageable = PageRequest.of(pageNo, pageSize, Sort.by(sort).ascending());
        }else {
            throw new BookException(ErrorEnum.ERROR_SORT_TYPE.getErrorMessage());
        }
        Page<Customer> customers = customerRepository.findAll(pageable);
        customers.forEach(c->{
            CustomerDTO customerDTO = CustomerMapper.INSTANCE.customerToCustomerDto(c);
            customerDTOList.add(customerDTO);
        });
        listResponse.setListCustomer(customerDTOList);
        listResponse.setTotalPage(customers.getTotalPages());
        return listResponse;
    }

    public Customer updateCustomerStatus(CustomerUpdateStatusRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId());
        customer.setStatus(request.getStatus());
        customerRepository.save(customer);
        return customer;
    }
}
