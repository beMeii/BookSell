package com.prm.group6.services.implement;

import com.prm.group6.exceptions.AccountException;
import com.prm.group6.model.dto.AccountDTO;
import com.prm.group6.model.dto.CustomerDTO;
import com.prm.group6.model.entity.Account;
import com.prm.group6.model.entity.Customer;
import com.prm.group6.repositories.AccountRepository;
import com.prm.group6.repositories.CustomerRepository;
import com.prm.group6.repositories.RoleRepository;
import com.prm.group6.services.AuthService;
import com.prm.group6.services.mappers.AccountMapper;
import com.prm.group6.services.mappers.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder encoder ;
    @Override
    public AccountDTO addCustomerAccount(AccountDTO accountDTO) {
        try{
            if(accountRepository.existsByEmail(accountDTO.getEmail())){
                System.out.println(AccountException.EMAIL_IS_DUPLICATE);
            }
            else {
                saveAccountToDatabas(accountDTO);
                saveCustomerToDatabase(accountDTO);
                return accountDTO;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Error at addCustomerAccount in AuthService");
        }
        return null;
    }

    @Override
    public CustomerDTO getCustomerDetails(AccountDTO signInDTO) {
        int customerId = accountRepository.findByEmail(signInDTO.getEmail()).get().getAccountId();
        return CustomerMapper.INSTANCE.customerToCustomerDto(customerRepository.findById(customerId));
    }

    private void saveAccountToDatabas(AccountDTO accountDTO){
        Account account = AccountMapper.INSTANCE.accountDtoToAccount(accountDTO);
        //System.out.println(account);
        account.setPassword(encoder.encode(account.getPassword()));
        account.setRoleId(roleRepository.findByRoleName("CUSTOMER").getRoleId());
        accountRepository.save(account);
    }
    private void saveCustomerToDatabase(AccountDTO accountDTO){
        Customer customer = CustomerMapper.INSTANCE.customerDtoToCustomer(accountDTO.getCustomerDetail());
//        System.out.println(customer);
        customer.setCustomerId(accountRepository.findByEmail(accountDTO.getEmail()).get().getAccountId());
        customer.setStatus("active");
        customerRepository.save(customer);
    }

}
