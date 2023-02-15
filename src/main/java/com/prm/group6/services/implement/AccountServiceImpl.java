package com.prm.group6.services.implement;
import com.prm.group6.exceptions.AccountException;
import com.prm.group6.model.dto.AccountDTO;
import com.prm.group6.model.entity.Account;
import com.prm.group6.repositories.AccountRepository;
import com.prm.group6.repositories.RoleRepository;
import com.prm.group6.services.AccountService;
import com.prm.group6.services.mappers.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountService
{
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder encoder ;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtServiceImpl jwtService;

    public AccountDTO addNewAccount(AccountDTO accountDTO){
        try {
            if(accountRepository.existsByEmail(accountDTO.getEmail())){
                System.out.println(AccountException.EMAIL_IS_DUPLICATE);
            }
            else {
                Account account = AccountMapper.INSTANCE.accountDtoToAccount(accountDTO);
                account.setPassword(encoder.encode(account.getPassword()));
                account.setRoleId(roleRepository.findByRoleName("CUSTOMER").getRoleId());
                accountRepository.save(account);
                return accountDTO;
            }
        }
        catch (Exception e){
            System.out.println("Error in AddNewAccount in AccountServiceImp account");
        }
        return null;
    }

    public String signIn(AccountDTO signInDTO){
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            signInDTO.getEmail(),
                            signInDTO.getPassword()
                    )
            );
            var UserDetails = customUserDetailsService.loadUserByUsername(signInDTO.getEmail());
            var jwtToken=jwtService.generateToken(UserDetails);
            return jwtToken;
        } catch (BadCredentialsException e){
            System.out.println(AccountException.WRONG_EMAIL_PASSWORD);
        }
        return null;
    }
}
