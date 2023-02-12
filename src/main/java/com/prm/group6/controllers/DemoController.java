package com.prm.group6.controllers;

import com.prm.group6.model.dto.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {
    @GetMapping(value = "/demo")
    public ResponseEntity<?> sayHello(){
        return ResponseEntity.ok(AuthenticationResponse.builder().token("Hello").build());
    }
}
