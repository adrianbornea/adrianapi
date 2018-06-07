package com.adrianapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class AdrianapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdrianapiApplication.class, args);
	}
}
