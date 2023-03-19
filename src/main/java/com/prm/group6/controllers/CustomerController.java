package com.prm.group6.controllers;

import com.prm.group6.model.dto.CustomerDTO;
import com.prm.group6.model.entity.Account;
import com.prm.group6.services.CustomerService;
import com.prm.group6.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    JwtService jwtService;
    @PostMapping("/updateCustomer")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestHeader(name="Authorization") String token, @RequestBody CustomerDTO customerDTO){
        Account acc = jwtService.getAccount(token);
        customerDTO.setCustomerId(acc.getAccountId());
        return new ResponseEntity<>(customerService.updateCustomer(customerDTO), HttpStatus.OK);
    }

    @PostMapping("/fbtoken")
    public ResponseEntity<CustomerDTO> updateFirebaseToken(
            @RequestHeader(name="Authorization") String token,
            @RequestParam(value = "firebaseToken", defaultValue = "", required = true) String firebaseToken){
        return new ResponseEntity<>(customerService.updateFirebaseToken(token, firebaseToken), HttpStatus.OK);
    }
}
