package com.prm.group6.services.implement;
import com.prm.group6.model.dto.SignUpDTO;
import com.prm.group6.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import com.prm.group6.model.dto.AuthenticationResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private AccountRepository repository;
    private final PasswordEncoder encoder;
    public AuthenticationResponse signUp(SignUpDTO signUpDTO){
        return null;
    }
    public AuthenticationResponse signIn(){
        return null;
    }

}
