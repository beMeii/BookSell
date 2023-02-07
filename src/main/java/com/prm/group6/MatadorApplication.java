package com.prm.group6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("model")
@ComponentScan({"api","com.prm.group6"})
@EnableJpaRepositories("repositories")

public class MatadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatadorApplication.class, args);
	}

}
