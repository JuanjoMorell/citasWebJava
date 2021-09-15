package com.example.citasWebJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.citasWebJava")
@EnableJpaRepositories(basePackages = "com.example.citasWebJava")
@EntityScan(basePackages = "com.example.citasWebJava")
public class CitasWebJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitasWebJavaApplication.class, args);
	}

}
