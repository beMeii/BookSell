package com.prm.group6;

import com.prm.group6.model.dto.AccountDTO;
import com.prm.group6.model.entity.Account;
import com.prm.group6.repositories.AccountRepository;
import com.prm.group6.services.AccountService;
import com.prm.group6.services.AuthService;
import com.prm.group6.services.implement.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(scanBasePackages={"com.prm.group6"})
@ComponentScan(basePackages = "com.prm.group6")
public class MatadorApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext appContext = SpringApplication.run(MatadorApplication.class, args);
//		AccountRepository service = appContext.getBean(AccountRepository.class);
//		PasswordEncoder encoder = appContext.getBean(PasswordEncoder.class);
//		Account account= new Account(120,"adminnenhe",encoder.encode("1"),1);
//		service.save(account);
	}
}
