package com.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import busLogic.clientLogic;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({ "com.app", "com.controll", "busLogicImp", "security" })
@EntityScan("com.entities")
@EnableJpaRepositories("com.services")
public class S3AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(S3AppApplication.class, args);
	}
/*
	@Bean
	CommandLineRunner start(clientLogic ad) {

		return args -> {
			
				ad.addClient("client", "1234", "1234", "email", "phone");
			
		};

	}
*/
	@Bean
	BCryptPasswordEncoder getBPCE() {
		return new BCryptPasswordEncoder();
	}
}
