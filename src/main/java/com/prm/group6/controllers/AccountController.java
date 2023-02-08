package com.prm.group6.controllers;

import com.prm.group6.model.dto.SignUpDTO;
import com.prm.group6.model.entity.Account;
import com.prm.group6.model.entity.Role;
import com.prm.group6.repositories.AccountRepository;
import com.prm.group6.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;
    @GetMapping(value = "/signup")
    public ResponseEntity<?> signUp(){
        return new ResponseEntity<>("Connected", HttpStatus.OK);
    }
    @PostMapping(value = "/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpDTO signUpDTO){

        try{
            if(accountRepository.existsByEmail(signUpDTO.getEmail())){
                return new ResponseEntity<>("Email is already exist!", HttpStatus.BAD_REQUEST);
            }
            Account acc = new Account();
            acc.setEmail(signUpDTO.getEmail());
            acc.setPassword(signUpDTO.getPassword());
            Role roles = roleRepository.findByRoleName("CUSTOMER");
            acc.setRoleId(roles.getRoleId());
            accountRepository.save(acc);
            return new ResponseEntity<>(acc, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Something went wrong: "+e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }
}
