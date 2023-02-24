package com.prm.group6.controllers;
import com.prm.group6.exceptions.AccountException;
import com.prm.group6.model.dto.AccountDTO;
import com.prm.group6.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
@Validated
public class AccountController {
    @Autowired
    private AccountService accountService;
    @PostMapping(value = "/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody AccountDTO accountDTO){
        try{
            AccountDTO acc = accountService.signUp(accountDTO);
            if (acc!=null) return new ResponseEntity<>(acc,HttpStatus.OK);
            else return new ResponseEntity<>(AccountException.EMAIL_IS_DUPLICATE,HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Something went wrong in signup controller: "+e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }
    @PostMapping(value = "/signin")
    public ResponseEntity<?> signIn(@Valid @RequestBody AccountDTO accountDTO){
        try {
            AccountDTO acc = accountService.signIn(accountDTO);
            if (acc != null) return new ResponseEntity<>(acc,HttpStatus.OK);
            else return new ResponseEntity<>(AccountException.WRONG_EMAIL_PASSWORD,HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Something went wrong in signin controller: "+e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }
}
