package com.prm.group6.services.implement;
import com.prm.group6.exceptions.AccountException;
import com.prm.group6.model.dto.AccountDTO;
import com.prm.group6.repositories.CustomerRepository;
import com.prm.group6.services.AccountService;
import com.prm.group6.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountService
{
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtServiceImpl jwtService;
    @Autowired
    private AuthService authService;

    public AccountDTO signUp(AccountDTO accountDTO){
        try {
            return authService.addCustomerAccount(accountDTO);
        }
        catch (Exception e){
            System.out.println("Error in AddNewAccount in AccountServiceImp account");
        }
        return null;
    }

    public AccountDTO signIn(AccountDTO signInDTO){
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            signInDTO.getEmail(),
                            signInDTO.getPassword()
                    )
            );
            var UserDetails = customUserDetailsService.loadUserByUsername(signInDTO.getEmail());
            signInDTO.setToken(jwtService.generateToken(UserDetails));
            signInDTO.setCustomerDetail(authService.getCustomerDetails(signInDTO));
            return signInDTO;
        } catch (BadCredentialsException e){
            System.out.println(AccountException.WRONG_EMAIL_PASSWORD);
        }
        return null;
    }
}
