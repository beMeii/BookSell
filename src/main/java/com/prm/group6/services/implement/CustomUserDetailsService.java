package com.prm.group6.services.implement;
import com.prm.group6.model.entity.Account;
import com.prm.group6.repositories.AccountRepository;
import com.prm.group6.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println(email);
        Account user = accountRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email: "+ email));
//        Set<GrantedAuthority> authorities = user
//                .getRoles()
//                .stream()
//                .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
        Set<GrantedAuthority> authorities = roleRepository
                .findAll()
                .stream()
                .map((role) -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toSet());
        System.out.println(authorities.toString());
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
    }
}
