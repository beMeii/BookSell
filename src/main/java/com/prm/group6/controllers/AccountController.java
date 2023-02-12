package com.prm.group6.controllers;
import com.prm.group6.model.dto.AuthenticationResponse;
import com.prm.group6.model.dto.SignInDTO;
import com.prm.group6.model.dto.SignUpDTO;
import com.prm.group6.model.entity.Account;
import com.prm.group6.model.entity.Role;
import com.prm.group6.repositories.AccountRepository;
import com.prm.group6.repositories.RoleRepository;
import com.prm.group6.services.implement.AuthenticationService;
import com.prm.group6.services.JwtService;
import com.prm.group6.services.implement.CustomUserDetailsService;
import com.prm.group6.services.implement.JwtServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/auth")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder encoder ;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    private final JwtServiceImpl jwtService;
    private final AuthenticationManager authenticationManager;
    @PostMapping(value = "/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpDTO signUpDTO){
        try{
            if(accountRepository.existsByEmail(signUpDTO.getEmail())){
                return new ResponseEntity<>("Email is already exist!", HttpStatus.BAD_REQUEST);
            }
            Account acc = new Account();
            acc.setEmail(signUpDTO.getEmail());
            acc.setPassword(encoder.encode(signUpDTO.getPassword()));
            Role roles = roleRepository.findByRoleName("CUSTOMER");
            acc.setRoleId(roles.getRoleId());
            accountRepository.save(acc);
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(signUpDTO.getEmail());
            System.out.println(userDetails);
            var jwtToken = jwtService.generateToken(userDetails);
            return ResponseEntity.ok(AuthenticationResponse.builder().token(jwtToken).build());
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Something went wrong: "+e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }
    @PostMapping(value = "/signin")
    public ResponseEntity<?> signIn(@RequestBody SignInDTO signInDTO){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInDTO.getEmail(),
                        signInDTO.getPassword()
                )
        );
        var UserDetails = customUserDetailsService.loadUserByUsername(signInDTO.getEmail());
        var jwtToken=jwtService.generateToken(UserDetails);
        return ResponseEntity.ok(AuthenticationResponse.builder().token(jwtToken).build());
    }
}
