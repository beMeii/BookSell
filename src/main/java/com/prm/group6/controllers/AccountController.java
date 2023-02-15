package com.prm.group6.controllers;
import com.prm.group6.model.dto.AccountDTO;
import com.prm.group6.model.entity.Account;
import com.prm.group6.repositories.AccountRepository;
import com.prm.group6.repositories.RoleRepository;
import com.prm.group6.services.AccountService;
import com.prm.group6.services.implement.CustomUserDetailsService;
import com.prm.group6.services.implement.JwtServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @PostMapping(value = "/signup")
    public ResponseEntity<?> signUp(@RequestBody AccountDTO accountDTO){
        try{
            return new ResponseEntity<>(accountService.addNewAccount(accountDTO),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Something went wrong in signup controller: "+e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }
    @PostMapping(value = "/signin")
    public ResponseEntity<?> signIn(@RequestBody AccountDTO accountDTO){
        try {
            return new ResponseEntity<>(accountService.signIn(accountDTO),HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Something went wrong in signin controller: "+e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }
}
