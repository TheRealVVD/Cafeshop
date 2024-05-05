package com.example.cafeshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CafeshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CafeshopApplication.class, args);
	}

}
