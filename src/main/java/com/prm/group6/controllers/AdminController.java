package com.prm.group6.controllers;

import com.prm.group6.model.dto.CustomerUpdateStatusRequest;
import com.prm.group6.model.dto.ListResponse;
import com.prm.group6.model.entity.Customer;
import com.prm.group6.services.BookService;
import com.prm.group6.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    BookService bookService;
    @Autowired
    CustomerService customerService;
    @GetMapping("/customer/retrieve")
    public ResponseEntity<ListResponse> getCustomerList(@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
                                                    @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
                                                    @RequestParam(value = "sort", defaultValue = "title",required = false) String sort,
                                                    @RequestParam(value = "sortType", defaultValue = "ASC",required = false) String sortType){
        return ResponseEntity.ok(customerService.getCustomerList(pageNo, pageSize, sort, sortType));
    }
    @PostMapping("/updateCustomer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody CustomerUpdateStatusRequest request){
        // chỉ cần truyền customerID, và status
        return new ResponseEntity<>(customerService.updateCustomerStatus(request), HttpStatus.OK);
    }
}
