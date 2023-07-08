package com.warleydev.apimedic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ApiMedicApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiMedicApplication.class, args);
	}

}
