package com.prm.group6;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={"com.prm.group6"})
@ComponentScan(basePackages = "com.prm.group6")

public class MatadorApplication {
	public static void main(String[] args) {
		SpringApplication.run(MatadorApplication.class, args);
	}
}
