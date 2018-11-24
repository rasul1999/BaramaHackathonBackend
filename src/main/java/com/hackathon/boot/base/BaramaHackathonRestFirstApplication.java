package com.hackathon.boot.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages= {"com.hackathon.model"})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages= {"com.hackathon.repository"})
@ComponentScan(basePackages= {"com.hackathon"})
public class BaramaHackathonRestFirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaramaHackathonRestFirstApplication.class, args);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
